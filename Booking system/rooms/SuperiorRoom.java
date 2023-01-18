package rooms;

public class SuperiorRoom extends AbstractRoom {
    private int additionalRoomPrice = 3500;
    @Override
    public int calculateRoomPrice() {
        int roomPrice = 0;
        int dayPrice = getSeasenBasedDefaultPrice();
        roomPrice = dayPrice + additionalRoomPrice;
        if (isExtraBedNeeded)
            roomPrice = roomPrice + extraBedPrice;
        return roomPrice;
    }
}
