import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        addUsers();
    }

    private static void writeUser(User newUser){
        File myFile = new File("user.txt");
        try (FileWriter fwr = new FileWriter(myFile, true);) {
            if (myFile.canWrite())
                fwr.append(String.valueOf(newUser)).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addUsers(){
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        int continueAdding = 0;
        while (flag) {
                System.out.println("Do you want to add another user? 1- yes, 0- no");
                continueAdding = sc.nextInt();
                if (continueAdding == 1)
                    fillUserFields();
                else
                    flag = false;
            }
    }

    private static void fillUserFields(){
        Scanner sc = new Scanner(System.in);
        int counter = 0;
        HashMap<String, Object> fields = new HashMap<>();
        while (fields.size() < User.class.getDeclaredFields().length) {
            String keyValueFull = User.class.getDeclaredFields()[counter++].toString();
            String keyExtracted = keyValueFull.substring(keyValueFull.lastIndexOf('.') + 1);
            System.out.println("Please enter " + keyExtracted);
            String val = sc.nextLine();
            fields.put(keyExtracted, val);
        }
        writeUser(new User(fields));
    }


}
