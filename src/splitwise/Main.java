package splitwise;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1, "Tanya");
        User user2 = new User(2, "Rahul");
        User user3 = new User(3, "Priya");

        Group group = new Group(1, "Goa Trip");
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);

        Expense expense = new Expense(1, 3000.0, "Hotel", user1, group);

        List<User> participants = Arrays.asList(user1, user2, user3);

        SplitManager splitManager = new SplitManager();
        ExpenseService expenseService = new ExpenseService(splitManager);

        List<ExpenseSplit> splits = expenseService.createExpense(expense, participants);

        System.out.println("Expense Splits:");
        for (ExpenseSplit split : splits) {
            System.out.println(split.getUser().getName() + " owes " + split.getShareAmount());
        }

        DebtSimplifier debtSimplifier = new DebtSimplifier();
        List<Settlement> settlements = debtSimplifier.simplifyDebts(Arrays.asList(expense), splits);

        System.out.println("\nSuggested Settlements:");
        for (Settlement settlement : settlements) {
            System.out.println(settlement.getFromUser().getName() + " pays " + settlement.getToUser().getName() + " " + settlement.getAmount());
        }
    }
}
