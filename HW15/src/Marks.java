import java.util.Scanner;

public class Marks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter a mark from 0 to 10 to get it meaning");
        int userInput = sc.nextInt();
        System.out.println(parseMark(userInput));
    }

    public static String parseMark(int mark){

        if(mark > 10 || mark < 0) return "Wrong mark value!";

        return switch (mark){

            case 9,10 -> "Well";
            case 7,8 -> "Good";
            case 6 -> "Acceptable";
            case 5 -> "Bad";
            default -> "Vary Bad";
        };
    }
}
