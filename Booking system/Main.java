
import java.util.Scanner;
import static bookingmanagement.UserInput.readUserInput;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        boolean isThereMoreBooking =true;
        
        do {
            readUserInput();
            System.out.println("Do you want to initiate a new booking process? Y or N ");
            String bookingContinue= scan.nextLine();
            if (bookingContinue.equalsIgnoreCase("n")){
                isThereMoreBooking= false;
                System.out.println("--------------------BOOKING IS OVER--------------------");
            }
        }while(isThereMoreBooking);
    }
}
