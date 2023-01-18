package rooms;

import java.time.LocalDate;
import java.time.Month;

public abstract class AbstractRoom {
    protected boolean isExtraBedNeeded;
    protected int extraBedPrice = 3000;
    private int seasonDefaultPrice;
    public int getSeasenBasedDefaultPrice() {
        LocalDate now = LocalDate.now();
        Month userMonth = now.getMonth();
        switch (userMonth) {
            case DECEMBER, JANUARY, FEBRUARY, MARCH, APRIL, MAY -> seasonDefaultPrice = 11000;
            case JUNE, JULY, AUGUST -> seasonDefaultPrice = 21000;
            case SEPTEMBER, OCTOBER, NOVEMBER -> seasonDefaultPrice = 15000;
        }
        return seasonDefaultPrice;
    }
    public abstract int calculateRoomPrice();
    public void setExtraBedNeeded(boolean extraBedNeeded) {
        isExtraBedNeeded = extraBedNeeded;
    }
}


