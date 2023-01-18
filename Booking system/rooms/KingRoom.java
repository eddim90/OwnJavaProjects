package rooms;

public class KingRoom extends AbstractRoom {
    protected int additionalRoomPrice = 11000;
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
