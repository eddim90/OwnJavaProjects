package bookingmanagement;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static bookingmanagement.DataWriter.dataWriter;

public class UserInput {
    public static void readUserInput() {
        Random randomRoomGenerator = new Random();

        int freeRoomStandard = randomRoomGenerator.nextInt(16);

        int freeRoomSuperior = randomRoomGenerator.nextInt(11);

        int freeRoomKing = randomRoomGenerator.nextInt(6);

// booking folytatásának lehetősége és teljes booking folyamat.Beolvasások és adat átküldése setterekkel

        System.out.println("Start your Booking now!" + '\n');

        Scanner scan = new Scanner(System.in);

        UserInformationReader userInfo = new UserInformationReader();


        System.out.println("***************Welcome Dear Customer!***************");
        System.out.println("Please provide the following informations:");

        System.out.println("What is your name?");
        String customerName = scan.nextLine();
        userInfo.setCustomerName(customerName);

        System.out.println("How many days will you stay?");
        int daysBooked = Integer.parseInt(scan.nextLine());
        userInfo.setNumberOfNights(daysBooked);

        System.out.println("How many resident?");
        int numberOfResident = Integer.parseInt(scan.nextLine());
        userInfo.setNumberOfResidents(numberOfResident);
        // szobák elérhetőségének ellenőrzése a randomgenerátórhoz képest
        boolean wrongRoom;
        do {
            System.out.println("Available rooms: " + '\n' + "Standard: " + freeRoomStandard + '\n' +
                    "Superior: " + freeRoomSuperior + '\n' + "King: " + freeRoomKing);
            System.out.println("Which room you like? Standard(1) - Superior(2) - King(3)?");
            int roomSelector = Integer.parseInt(scan.nextLine());
            userInfo.setRoomType(roomSelector);
            if (roomSelector == 1 && freeRoomStandard == 0) {
                System.out.println("Sorry, the room is not available, choose another one!");
                wrongRoom = true;
            } else if (roomSelector == 2 && freeRoomSuperior == 0) {
                System.out.println("Sorry, the room is not available, choose another one!");
                wrongRoom = true;
            } else if (roomSelector == 3 && freeRoomKing == 0) {
                System.out.println("Sorry, the room is not available, choose another one!");
                wrongRoom = true;
            } else {
                wrongRoom = false;
            }
        } while (wrongRoom);
        System.out.println("Do you need extra bed?");
        String extraBed = scan.nextLine();
        if (extraBed.equalsIgnoreCase("Yes")) {
            extraBed = "True";
        } else {
            extraBed = "False";
        }
        userInfo.setExtraBedNeeded(Boolean.parseBoolean(extraBed));
        System.out.println("Would you like breakfast?");
        String breakfast = scan.nextLine();
        if (breakfast.equalsIgnoreCase("Yes")) {
            breakfast = "True";
        } else {
            breakfast = "False";
        }
        userInfo.setBreakfastNeeded(Boolean.parseBoolean(breakfast));
// metódus behívása és lementése változóba, amit átadunk a newBooking osztály metódusának

        ArrayList<String> reservationData = userInfo.getUserInputSavedArray();

        BookingService reservation = new BookingService();

        reservation.newBooking(reservationData);

        System.out.println(userInfo);

        dataWriter(userInfo);

    }
}
