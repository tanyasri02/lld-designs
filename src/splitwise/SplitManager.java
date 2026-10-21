
package splitwise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SplitManager {

    public List<ExpenseSplit> calculateSplits(Expense expense, List<User> participants) {

        if (expense == null || participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("Expense and participants are required");
        }

        BigDecimal totalAmount = BigDecimal.valueOf(expense.getAmount());
        BigDecimal shareAmount = totalAmount.divide(BigDecimal.valueOf(participants.size()), 2, java.math.RoundingMode.DOWN);

        List<ExpenseSplit> splits = new ArrayList<>();
        BigDecimal allocatedAmount = BigDecimal.ZERO;
        // add whatever is pending to last user
        for (int i = 0; i < participants.size(); i++) {
            BigDecimal share;

            if (i == participants.size() - 1) {
                share = totalAmount.subtract(allocatedAmount);
            } else {
                share = shareAmount;
                allocatedAmount = allocatedAmount.add(share);
            }

            splits.add(new ExpenseSplit(i + 1, expense, participants.get(i), share.doubleValue()));
        }

        return splits;
    }
}

