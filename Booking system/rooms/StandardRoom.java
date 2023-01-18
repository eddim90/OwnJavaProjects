package rooms;

public class StandardRoom extends AbstractRoom {

    @Override
    public int calculateRoomPrice() {
        int roomPrice = 0;
        roomPrice = getSeasenBasedDefaultPrice();
        if (isExtraBedNeeded)
            roomPrice = roomPrice + extraBedPrice;
        return roomPrice;
    }
}
