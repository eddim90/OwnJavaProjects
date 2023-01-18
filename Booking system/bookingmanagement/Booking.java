package bookingmanagement;

public class Booking {

    private int roomPrice;
    private int person;
    private int days;
    private String bookingName;
    private int breakfastPrice = 4500;

    public Booking(int roomPrice, int person, int days, String bookingName) {
        this.roomPrice = roomPrice;
        this.person = person;
        this.days = days;
        this.bookingName = bookingName;
    }
    public int getTotalCost(int roomPrice, int days, int breakfastPrice) {
        return (roomPrice * days) + (breakfastPrice * person * days);
    }
    public int getBreakfastPrice() {
        return breakfastPrice;
    }

}
