package bookMyShow;

public class ShowSeat {
    private Show show;
    private Seat seat;
    private SeatStatus status;

    public ShowSeat(Show show, Seat seat, SeatStatus status){
        this.show = show;
        this.seat = seat;
        this.status = status;
    }

    public Seat getSeat() {
        return seat;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public Show getShow() {
        return show;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
