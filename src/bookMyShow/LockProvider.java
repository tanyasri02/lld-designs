package bookMyShow;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LockProvider {

    private final Set<String> lockedSeats = new HashSet<>();

    public synchronized boolean lockSeats(Show show, List<ShowSeat> seats) {
        for (ShowSeat showSeat : seats) {
            String key = getSeatKey(show, showSeat);

            if (lockedSeats.contains(key) || showSeat.getStatus() != SeatStatus.AVAILABLE) {
                return false;
            }
        }
        for (ShowSeat showSeat : seats) {
            lockedSeats.add(getSeatKey(show, showSeat));
        }

        return true;
    }

    public synchronized void releaseSeats(Show show, List<ShowSeat> seats) {

        for (ShowSeat showSeat : seats) {
            lockedSeats.remove(getSeatKey(show, showSeat));
        }
    }

    private String getSeatKey(Show show, ShowSeat showSeat) {
        return show.getId() + "-" + showSeat.getSeat().getId();
    }
}
