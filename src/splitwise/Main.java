
package splitwise;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Tanya");
        User user2 = new User(2, "Shiwam");
        User user3 = new User(3, "Ayushi");

        Group group = new Group(1, "Goa Trip");
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);

        List<User> participants = Arrays.asList(user1, user2, user3);

        SplitManager splitManager = new SplitManager();
        ExpenseService expenseService = new ExpenseService(splitManager);

        Expense expense1 = new Expense(1, 3000.0, "Hotel", user1, group);
        List<ExpenseSplit> splits1 = expenseService.createExpense(expense1, participants);

        Expense expense2 = new Expense(2, 1500.0, "Food", user2, group);
        List<ExpenseSplit> splits2 = expenseService.createExpense(expense2, participants);

        List<ExpenseSplit> allSplits = new java.util.ArrayList<>(splits1);
        allSplits.addAll(splits2);

        System.out.println("Expense Splits:");
        for (ExpenseSplit split : allSplits) {
            System.out.println(split.getUser().getName() + " owes " + split.getShareAmount());
        }

        DebtSimplifier debtSimplifier = new DebtSimplifier();
        List<Settlement> settlements = debtSimplifier.simplifyDebts(allSplits);

        System.out.println("\nSuggested Settlements:");
        for (Settlement settlement : settlements) {
            System.out.println(settlement.getFromUser().getName() + " pays " + settlement.getToUser().getName() + " " + settlement.getAmount());
        }
    }
}
