package Task103;

import java.time.LocalDate;
import java.util.*;

import static Task103.PersonCreator.getPerson;
import static Task103.ReadingMethod.userInput;


public class Main {


    public static void main(String[] args) {

        List<String> personInfos = userInput();

        Person adam = getPerson(personInfos);

        System.out.println(adam);

    }
}
