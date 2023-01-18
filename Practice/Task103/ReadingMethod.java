package Task103;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadingMethod {


    public static List<String> userInput() {
        int weight;
        int age;
        int height;


        List<String> personInformation = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("First name: ");
        String fName = scan.nextLine();
        personInformation.add(fName);


        System.out.println("Last name: ");
        String lastName = scan.nextLine();
        personInformation.add(lastName);


        System.out.println("Birth Place: ");
        String birthPlace = scan.nextLine();
        personInformation.add(birthPlace);

        try {

            System.out.println("Your Body Height: ");
            height = Integer.parseInt(scan.nextLine());
            personInformation.add(String.valueOf(height));
        } catch (NumberFormatException e) {
            height = 0;
            personInformation.add(String.valueOf(height));

        }

        System.out.println("Birth Date: ");
        LocalDate birthDate = LocalDate.parse(scan.nextLine());
        personInformation.add(String.valueOf(birthDate));


        System.out.println("Favorite movies of yours? ");
        String input = scan.nextLine();
        List<String> movies = Arrays.asList(input.split(","));
        personInformation.add(movies.toString());


        System.out.println("Are you happy? Yes / No ");
        String happyInput = scan.nextLine();
        boolean happy;
        happy = happyInput.equalsIgnoreCase("Yes");
        personInformation.add(String.valueOf(happy));


        try {

            System.out.println("Your weight:");
            weight = Integer.parseInt(scan.nextLine());
            personInformation.add(String.valueOf(weight));

        } catch (NumberFormatException e) {
            weight = 0;
            personInformation.add(String.valueOf(weight));


        }
        try {
            System.out.println("Your age:");
            age = Integer.parseInt(scan.nextLine());
            personInformation.add(String.valueOf(age));


        } catch (NumberFormatException e) {
            age = 0;
            personInformation.add(String.valueOf(age));


        }


        return personInformation;


    }


}
