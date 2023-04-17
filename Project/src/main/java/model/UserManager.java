package model;

import java.util.ArrayList;

public class UserManager {

    private static ArrayList<User> users;
    private static ArrayList<User> loggedInUsers;

    static {
        users = new ArrayList<>();
        loggedInUsers = new ArrayList<>();
    }

    public static User createClient(String firstName, String lastName, String email, String password, double budget) {
        User newUser = new Client(firstName, lastName, email, password, budget);
        return validateUser(newUser);
    }

    public static User createAdmin(String firstName, String lastName, String email, String password) {
        User newUser = new Admin(firstName, lastName, email, password);
        return validateUser(newUser);
    }


    private static User validateUser(User user) {
        if (!checkUserPresence(user))
            users.add(user);
        else
            return null;
        return user;
    }

    public static boolean lockUser(User lockedBy, int id) {
        User userToLock = findUserById(id);
        if (userToLock == null) {
            System.out.println("Cannot find a user with such an Id...");
            return false;
        }

        if (userToLock.status == UserStatus.ACTIVE) {
            userToLock.setStatus(UserStatus.BLOCKED);
            System.out.println("User with Id: " + userToLock.getId() + " locked by: " + lockedBy.getUserFullName() +
                    "-" + lockedBy.getStatus());
            return true;
        } else
            System.out.println(userToLock.getUserFullName() + " has already been locked! ");
        return false;
    }

    public static boolean unlockUser(User unlockedBy, int id) {
        User userToLock = findUserById(id);
        if (userToLock == null) {
            System.out.println("Cannot find a user with such an Id...");
            return false;
        }
        if (userToLock.status == UserStatus.BLOCKED) {
            userToLock.setStatus(UserStatus.ACTIVE);
            System.out.println("User with Id: " + userToLock.getId() + " unlocked by: " + unlockedBy.getUserFullName() +
                    "-" + unlockedBy.getStatus());
            return true;
        } else
            System.out.println(userToLock.getUserFullName() + " is not locked! ");
        return false;
    }

    /*
    public static User login(String email, String password){
        for(User user : loggedInUsers){
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                return user;
        }
        for(User user : users){
            if (user.getEmail().equals(email) && user.getPassword().equals(password) && user.getStatus() == UserStatus.ACTIVE) {
                loggedInUsers.add(user);
                return user;
            }
        }
        return null;
    }


    public static void logout(User user){
        for(User usr: loggedInUsers){
            if (usr.equals(user)){
                loggedInUsers.remove(usr);
            }
        }

    }

    */

    public static boolean isLoggedIn(User user) {
        for (User usr : loggedInUsers) {
            if (user.equals(usr))
                return true;
        }
        return false;
    }

    static boolean checkUserPresence(User user) {
//        if (user == null) return false;
        for (User usr : users) {
            if (usr.equals(user))
                return true;
        }
        return false;
    }

    public static User findUserById(Integer id) {

        for (User usr : users) {
            if (usr.getId().equals(id))
                return usr;
        }
        return null;
    }

    public static User findUserByEmail(String login) {
        for (User usr : users) {
            if (usr.getEmail().equals(login))
                return usr;
        }
        return null;
    }

    public static void displayAllUsers() {
        for (User usr : users) {
            System.out.println(usr);
        }
    }

    public static ArrayList<User> getAllUsers() {
        return users;
    }

    public static ArrayList<User> getLoggedInUsers() {
        return loggedInUsers;
    }

    public static int getUsersAmount() {
        return users.size();
    }

    public static int getLoggedInUsersAmount() {
        return loggedInUsers.size();
    }


}
