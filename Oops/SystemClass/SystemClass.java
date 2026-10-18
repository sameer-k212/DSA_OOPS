import java.util.*;
public class SystemClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        // get student score from the user

        System.out.println("Enter grade");

        int studentGrade = input.nextInt();



        // condition for invalid score

        if (studentGrade < 0 || studentGrade > 100) {

            System.err.println("Invalid grade."); // just like System.out.println();

            System.exit(0); // This method is used to exit current program by terminating the running Java virtual machine. This method takes a status code.
//            exit(0) : Generally used to indicate successful termination.
//            exit(1) or exit(-1) or any other non-zero value – Generally indicates unsuccessful termination.
        }


        // if studentGrade is 50 or above, display pass and congratulatory

        // message else display failed message

        if (studentGrade >= 50) {

            System.out.println("Congratulations!");

            System.out.println("You passed the examination.");

        } else {

            System.out.println("Sorry.\nYou failed the examination.");

        }

        input.close();
    }
}
