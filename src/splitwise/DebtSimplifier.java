
package splitwise;

import java.util.*;

public class DebtSimplifier {

    public List<Settlement> simplifyDebts(List<ExpenseSplit> splits) {
        Map<User, Double> balances = new HashMap<>();

        for (ExpenseSplit split : splits) {
            User debtor = split.getUser();
            User creditor = split.getExpense().getPaidByUser();
            double amount = split.getShareAmount();

            if (debtor.equals(creditor)) continue;

            balances.merge(debtor, -amount, Double::sum);
            balances.merge(creditor, amount, Double::sum);
        }

        List<User> users = new ArrayList<>();
        List<Double> balanceList = new ArrayList<>();

        for (Map.Entry<User, Double> entry : balances.entrySet()) {
            if (Math.abs(entry.getValue()) > 0.01) {
                users.add(entry.getKey());
                balanceList.add(entry.getValue());
            }
        }

        double[] debts = new double[balanceList.size()];
        for (int i = 0; i < debts.length; i++) debts[i] = balanceList.get(i);

        List<Settlement> settlements = new ArrayList<>();
        simplify(debts, users, 0, settlements);

        for (int i = 0; i < settlements.size(); i++) {
            Settlement s = settlements.get(i);
            settlements.set(i, new Settlement(i + 1, s.getFromUser(), s.getToUser(), s.getAmount(), SettlementStatus.PENDING));
        }

        return settlements;
    }

    private int simplify(double[] debts, List<User> users, int start, List<Settlement> best) {
        while (start < debts.length && Math.abs(debts[start]) < 0.01) start++;
        if (start == debts.length) return 0;

        int minTransactions = Integer.MAX_VALUE;
        List<Settlement> bestForCurrent = new ArrayList<>();

        for (int i = start + 1; i < debts.length; i++) {
            if (debts[start] * debts[i] < 0) {
                double original = debts[i];
                double amount = Math.min(Math.abs(debts[start]), Math.abs(debts[i]));

                User from = debts[start] > 0 ? users.get(start) : users.get(i);
                User to = debts[start] > 0 ? users.get(i) : users.get(start);

                debts[i] += debts[start];

                List<Settlement> current = new ArrayList<>();
                current.add(new Settlement(0, from, to, amount, SettlementStatus.PENDING));

                int count = 1 + simplify(debts, users, start + 1, current);

                if (count < minTransactions) {
                    minTransactions = count;
                    bestForCurrent = new ArrayList<>(current);
                }

                debts[i] = original;

                if (Math.abs(original + debts[start]) < 0.01) break;
            }
        }

        best.clear();
        best.addAll(bestForCurrent);
        return minTransactions;
    }
}
