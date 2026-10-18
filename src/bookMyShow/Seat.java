package bookMyShow;

public class Seat {
    private int id;
    private SeatType seatType;
    private String seatNumber;

    public Seat(int id, SeatType seatType, String seatNumber){
        this.id = id;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
    }

    public int getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
