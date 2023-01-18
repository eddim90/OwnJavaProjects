package bookingmanagement;

import rooms.KingRoom;
import rooms.StandardRoom;
import rooms.SuperiorRoom;

import java.util.ArrayList;

public class BookingService implements BookingInterface {

    @Override
    public void newBooking(ArrayList<String> bookingList) {
// inputként kapott array tömb index alapú feldolgozása és változókhoz történő rendelése- átalakítása. Egyes változók bevezetése is
        // itt történik
        String name = bookingList.get(0);

        int person = Integer.parseInt(bookingList.get(1));

        int days = Integer.parseInt(bookingList.get(2));

        boolean breakfastChoice = bookingList.get(5).equalsIgnoreCase("True");

        int breakfastPrice = 0;

        int roomPrice = 0;

// A szobatípusok példányosítása további felhasználáshoz
        KingRoom king = new KingRoom();

        SuperiorRoom superior = new SuperiorRoom();

        StandardRoom standard = new StandardRoom();

//Szobaválasztó rendszer kidolgozása. A metódusnak átadott tömb index alapú feldolgozása, hogy melyik szoba felel meg az adott felhasználói
        //választásnak. Amennyiben pótágyat is kér a felhasználó úgy a rooms package-ben lévő megfelelő szoba osztály metódusa számol vele
        try {
            if (bookingList.get(3).equalsIgnoreCase("King")) {
                roomPrice = king.calculateRoomPrice();
                if (bookingList.get(4).equalsIgnoreCase("True")) {
                    king.setExtraBedNeeded(true);
                    roomPrice = king.calculateRoomPrice();
                }
            } else if (bookingList.get(3).equalsIgnoreCase("Superior")) {
                roomPrice = superior.calculateRoomPrice();
                if (bookingList.get(4).equalsIgnoreCase("True")) {
                    superior.setExtraBedNeeded(true);
                    roomPrice = superior.calculateRoomPrice();
                }
            } else {
                roomPrice = standard.calculateRoomPrice();
                if (bookingList.get(4).equalsIgnoreCase("True")) {
                    standard.setExtraBedNeeded(true);
                    roomPrice = standard.calculateRoomPrice();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Something went wrong with the rooms" + e.getMessage());
        }
// példányosítás a booking osztályból, hogy megfelelő adatok áthozhatóak legyenek a POJO osztályból és a totalCost metódus használható legyen.
        Booking bookedPerson = new Booking(roomPrice, person, days, name);

        if (breakfastChoice)
            breakfastPrice = bookedPerson.getBreakfastPrice();

        int totalCost = bookedPerson.getTotalCost(roomPrice, days, breakfastPrice);

        System.out.println("--------------------------------------");

        System.out.println("Your total cost is: " + totalCost + " Forint");
    }
}
