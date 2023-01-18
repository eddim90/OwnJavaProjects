package Task103;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class PersonCreator {

    public static Person getPerson(List<String> userInput) {

        int height = Integer.parseInt(userInput.get(3));
        LocalDate birthDate = LocalDate.parse(userInput.get(4));
        List<String> movies = Collections.singletonList(userInput.get(5));
        boolean happy = Boolean.parseBoolean(userInput.get(6));
        int weight = Integer.parseInt(userInput.get(7));
        int age = Integer.parseInt(userInput.get(8));
        Person person = new Person(userInput.get(0), userInput.get(1), userInput.get(2), height, birthDate, movies, happy);
        if (weight != 0) {
            person.setBodyWeight(weight);
        }
        if (age != 0) {
            person.setAge(age);
        }
        return person;
    }
}
