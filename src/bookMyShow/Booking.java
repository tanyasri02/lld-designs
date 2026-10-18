package bookMyShow;

import java.util.List;

public class Booking {
    private int id;
    private User user;
    private Show show;
    private List<ShowSeat> showSeatList;
    private BookingStatus bookingStatus;

    public Booking(int id, User user, Show show, List<ShowSeat> showSeatList, BookingStatus bookingStatus){
        this.id = id;
        this.user = user;
        this.show = show;
        this.showSeatList = showSeatList;
        this.bookingStatus = bookingStatus;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public List<ShowSeat> getShowSeatList() {
        return List.copyOf(showSeatList);
    }

    public void confirmBooking() {
        this.bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancelBooking() {
        this.bookingStatus = BookingStatus.CANCELLED;
    }
}
