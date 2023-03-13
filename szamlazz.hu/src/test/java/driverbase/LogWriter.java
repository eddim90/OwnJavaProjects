package driverbase;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {
    public void dataWriter(String testFeedback) {
        LocalDate now = LocalDate.now();
        String date = now.toString();
        LocalDateTime now2 = LocalDateTime.now();
        DateTimeFormatter nowFormatted = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String finalDateTime=  now2.format(nowFormatted);
        try {
            File file = new File("src/LogFolder/logfile-" + date + ".txt");
            boolean fileExists = file.exists();
            if (!fileExists) {
                Files.writeString(Path.of("src/LogFolder/logfile-" + date + ".txt"),finalDateTime+ testFeedback);
            } else {
                Files.writeString(Path.of("src/LogFolder/logfile-" + date + ".txt"), finalDateTime+ testFeedback, StandardOpenOption.APPEND);
            }
            System.out.println("Logfile saved");
        } catch (
                IOException e) {
            System.out.println("Something went wrong, file not saved. Error code:" + e.getMessage());
        }
    }
}
