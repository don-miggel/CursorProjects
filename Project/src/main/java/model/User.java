package model;


import service.UserService;

import java.util.Objects;

public abstract class User implements UserService {

    private static int amount;
    protected final Integer Id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected UserRole role;
    protected UserStatus status;

    static {
        amount = 0;
    }

    User(String firstName, String lastName, String email, String password, UserRole role) {
        Id = ++amount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = UserStatus.ACTIVE;
    }

    public static int usersAmount() {
        return amount;
    }

    public Integer getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserStatus getStatus() {
        return status;
    }

    public String getUserRoleAsString() {
        if (role.equals(UserRole.ADMIN))
            return "Admin";
        else
            return "Client";
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getUserFullName() {
        return " first name: " + getFirstName() + ",last name: " + getLastName();
    }

    @Override
    public boolean login(String username, String password) {
        /*
        if(UserManager.getLoggedInUsers().contains(this)){
            System.out.println("You are already logged in !");
//            return false;
        }else {
            UserManager.getLoggedInUsers().add(this);
//            return true;
        }
//        return false;

         */
        /*
        for(User user : UserManager.getLoggedInUsers()){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("You are already logged in !");
 //               return true;
            }
        }

         */
        if (UserManager.getLoggedInUsers().contains(this)) {
            System.out.println("You are already logged in !");
            return true;
        } else {
            for (User user : UserManager.getAllUsers()) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getStatus() == UserStatus.ACTIVE) {
                    UserManager.getLoggedInUsers().add(user);
                    if (UserManager.isLoggedIn(this)) {
                        System.out.println("User with" + getUserFullName() + " has successfully logged in. " +
                                "Your user role is: " + getUserRoleAsString());
                        return true;
                    } else {
                        System.out.println("Some login error occurred !");
                        return false;
                    }
                }
            }

        }
        System.out.println("Wrong credentials");
        return false;
    }

    @Override
    public void logout() {
        /*
        Iterator<User> it = UserManager.getLoggedInUsers().iterator();
        while (it.hasNext()){
            User usr = it.next();
            if (usr.equals(this)){
                UserManager.getLoggedInUsers().remove(usr);
            }
        }

         */
        if (UserManager.getLoggedInUsers().contains(this))
            UserManager.getLoggedInUsers().remove(this);
        else
            System.out.println("You are not logged id !");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return this.getClass().getName() +
                "{ Id=' " + Id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=' " + role + '\'' +
                ", status=' " + status + '\'' +
                '}';
    }
}
