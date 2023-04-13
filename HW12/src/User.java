import java.io.Serializable;
import java.util.HashMap;

public class User implements Serializable {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String age;

    User(String firstName, String lastName, String email, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public User(HashMap<String, Object> fields) {
        this((String) fields.get("firstName"), (String) fields.get("lastName"), (String) fields.get("email"),
                (String) fields.get("age"));
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
