package splitwise;

import java.util.*;

public class DebtSimplifier {
    public List<Settlement> simplifyDebts(List<Expense> expenses, List<ExpenseSplit> splits) {
        Map<User, Map<User, Double>> graph = new HashMap<>();
        Map<User, Double> balances = new HashMap<>();

        for (Expense expense : expenses) {
            User payer = expense.getPaidByUser();
            graph.putIfAbsent(payer, new HashMap<>());
            balances.putIfAbsent(payer, 0.0);
        }

        for (ExpenseSplit split : splits) {
            User debtor = split.getUser();
            User creditor = split.getExpense().getPaidByUser();
            double amount = split.getShareAmount();

            graph.putIfAbsent(debtor, new HashMap<>());
            graph.putIfAbsent(creditor, new HashMap<>());
            graph.get(debtor).put(creditor, graph.get(debtor).getOrDefault(creditor, 0.0) + amount);
            balances.put(debtor, balances.getOrDefault(debtor, 0.0) - amount);
            balances.put(creditor, balances.getOrDefault(creditor, 0.0) + amount);
        }

        Queue<Map.Entry<User, Double>> debtors = new LinkedList<>();
        Queue<Map.Entry<User, Double>> creditors = new LinkedList<>();

        for (Map.Entry<User, Double> entry : balances.entrySet()) {
            double balance = entry.getValue();
            if (balance < -0.01) debtors.offer(new AbstractMap.SimpleEntry<>(entry.getKey(), -balance));
            else if (balance > 0.01) creditors.offer(new AbstractMap.SimpleEntry<>(entry.getKey(), balance));
        }

        List<Settlement> settlements = new ArrayList<>();
        int settlementId = 1;

        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            Map.Entry<User, Double> debtor = debtors.poll();
            Map.Entry<User, Double> creditor = creditors.poll();
            double amount = Math.min(debtor.getValue(), creditor.getValue());

            settlements.add(new Settlement(settlementId++, debtor.getKey(), creditor.getKey(), amount, SettlementStatus.PENDING));

            double remainingDebt = debtor.getValue() - amount;
            double remainingCredit = creditor.getValue() - amount;

            if (remainingDebt > 0.01) debtors.offer(new AbstractMap.SimpleEntry<>(debtor.getKey(), remainingDebt));
            if (remainingCredit > 0.01) creditors.offer(new AbstractMap.SimpleEntry<>(creditor.getKey(), remainingCredit));
        }

        return settlements;
    }
}