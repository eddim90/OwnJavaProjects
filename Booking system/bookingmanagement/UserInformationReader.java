package bookingmanagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;


public class UserInformationReader {


    private String customerName;
    private int numberOfResidents;
    private int numberOfNights;
    private int roomType;
    private String roomName;
    private boolean extraBedNeeded;
    private boolean breakfastNeeded;
    ArrayList<String> userInputSavedArray = new ArrayList<>();

    public ArrayList<String> getUserInputSavedArray() {
        switch (getRoomType()) {
            case 1 -> roomName = String.valueOf(RoomType.STANDARD);
            case 2 -> roomName = String.valueOf(RoomType.SUPERIOR);
            case 3 -> roomName = String.valueOf(RoomType.KING);
        }
        userInputSavedArray.add(0, getCustomerName());
        userInputSavedArray.add(1, String.valueOf(getNumberOfResidents()));
        userInputSavedArray.add(2, String.valueOf(getNumberOfNights()));
        userInputSavedArray.add(3, getRoomName());
        userInputSavedArray.add(4, String.valueOf(isExtraBedNeeded()));
        userInputSavedArray.add(5, String.valueOf(isBreakfastNeeded()));
        return userInputSavedArray;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfResidents() {
        return numberOfResidents;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public int getRoomType() {
        return roomType;
    }

    public boolean isExtraBedNeeded() {
        return extraBedNeeded;
    }

    public boolean isBreakfastNeeded() {
        return breakfastNeeded;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setRoomType(int roomType) {
        this.roomType = roomType;
    }

    public void setExtraBedNeeded(boolean extraBedNeeded) {
        this.extraBedNeeded = extraBedNeeded;
    }

    public void setBreakfastNeeded(boolean breakfastNeeded) {
        this.breakfastNeeded = breakfastNeeded;
    }

    @Override
    public String toString() {
        return '\n' + "Guest details:" + '\n' +
                "Name: " + customerName + '\n' +
                "Number of residents: " + numberOfResidents + '\n' +
                "Number of nights: " + numberOfNights + '\n' +
                "Room type: " + roomName + '\n' +
                "Extra bed: " + (extraBedNeeded ? "Yes" : "No") + '\n' +
                "Breakfast included: " + (breakfastNeeded ? "Yes" : "No") + '\n' +
                "-------------------------------------------------------" + ' ';
    }
}
