
package splitwise;

import java.util.List;

public class ExpenseService {

    private final SplitManager splitManager;

    public ExpenseService(SplitManager splitManager) {
        this.splitManager = splitManager;
    }

    public List<ExpenseSplit> createExpense(Expense expense, List<User> participants) {
        if (expense == null) {
            throw new IllegalArgumentException("Expense cannot be null");
        }

        if (expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Expense amount must be positive");
        }

        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("Participants cannot be empty");
        }

        return splitManager.calculateSplits(expense, participants);
    }
}
