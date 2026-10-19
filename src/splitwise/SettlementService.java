package splitwise;

import java.util.ArrayList;
import java.util.List;

public class SettlementService {
    private final List<Settlement> settlements = new ArrayList<>();

    public Settlement createSettlement(User fromUser, User toUser, double amount) {
        if (fromUser == null || toUser == null) throw new IllegalArgumentException("Users cannot be null");

        if (fromUser.equals(toUser)) throw new IllegalArgumentException("Users must be different");

        if (amount <= 0) throw new IllegalArgumentException("Settlement amount must be positive");

        Settlement settlement = new Settlement(settlements.size() + 1, fromUser, toUser, amount, SettlementStatus.PENDING);
        settlements.add(settlement);
        return settlement;
    }

    public boolean completeSettlement(int settlementId) {
        for (Settlement settlement : settlements) {
            if (settlement.getId() == settlementId && settlement.getStatus() == SettlementStatus.PENDING) {
                settlement.setStatus(SettlementStatus.ACCEPTED);
                return true;
            }
        }

        return false;
    }

    public List<Settlement> getSettlements() {
        return new ArrayList<>(settlements);
    }
}