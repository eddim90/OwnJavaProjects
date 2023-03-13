package jsonDTO;

public class RegistrationData {
    String firstName;
    String secondName;
    String email;
    String wrongEmail;
    String PWD;
    String PWD2;

    public RegistrationData(String firstName, String secondName, String email, String wrongEmail, String PWD, String PWD2) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.wrongEmail = wrongEmail;
        this.PWD = PWD;
        this.PWD2 = PWD2;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public String getWrongEmail() {
        return wrongEmail;
    }

    public String getPWD() {
        return PWD;
    }

    public String getPWD2() {
        return PWD2;
    }
}
