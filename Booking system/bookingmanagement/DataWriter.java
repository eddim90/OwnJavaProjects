package bookingmanagement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;

public class DataWriter {

    public static void dataWriter(UserInformationReader userInfo) {

        LocalDate now = LocalDate.now();

        String date = now.toString();

        try {
            File file = new File("src/SavedData/foglalási-adatok-" + date + ".txt");
            boolean fileExists = file.exists();
            if (!fileExists) {
                Files.writeString(Path.of("src/SavedData/foglalási-adatok-" + date + ".txt"), userInfo.toString());
            } else {
                Files.writeString(Path.of("src/SavedData/foglalási-adatok-" + date + ".txt"), userInfo.toString(), StandardOpenOption.APPEND);
            }
            System.out.println("Data saved to file");
        } catch (
                IOException e) {
            System.out.println("Something went wrong, file not saved. Error code:" + e.getMessage());
        }
    }
}
