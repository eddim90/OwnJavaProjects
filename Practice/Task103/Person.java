package Task103;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Person {

    private String firstName;
    private String lastName;
    private String birthPlace;
    private LocalDate birthDate;
    private List<String> favoriteMovies;
    private boolean isHappy;
    private int bodyHeight;

    private int bodyWeight;
    private int age;

    public Person() {

    }


    public Person(int age, int bodyWeight) {
        this.age = age;
        this.bodyWeight = bodyWeight;
    }

    public Person(String firstName, String lastName, String birthPlace, int bodyHeight, LocalDate birtDate, List<String> favoriteMovies, boolean isHappy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bodyHeight = bodyHeight;
        this.birthPlace = birthPlace;
        this.birthDate = birtDate;
        this.favoriteMovies = favoriteMovies;
        this.isHappy = isHappy;

    }

    public void setBodyWeight(int bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person information: " + "\n" +
                " First Name: " + firstName + "\n" +
                " Last Name: " + lastName + "\n" +
                " Place of birth: " + birthPlace + "\n" +
                " Date of birth: " + birthDate + "\n" +
                " List of favorite movies: " + favoriteMovies + "\n" +
                " Are you happy? " + (isHappy ? "Yes": "No") + "\n" +
                " Height: " + bodyHeight + " Cm" + "\n" +
                " Weight: " + bodyWeight + " Kg" + "\n" +
                " Age: " + age + "\n" +
                ' ';
    }

}
