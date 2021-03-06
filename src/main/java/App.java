import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;


public class App {
    public static void main(String[] args) {

        Generator generator = new Generator();
        boolean globalFlag = true;
        Scanner in = new Scanner(System.in);
        while (globalFlag) {
            System.out.println("Choose how to use program: ");
            System.out.println("0 - Use generator.");
            System.out.println("1 - Use recognizer. ");
            System.out.println("Or type 'q' to end program ");
            int answer = -1;
            String s1 = in.nextLine();
            String toCheck1 = StringUtils.substringBefore(s1, " ");
            if (toCheck1.matches("\\d+")) {
                int gotAnswer = Integer.parseInt(toCheck1);
                if (gotAnswer < 0 || gotAnswer > 1) {
                    System.out.println("Wrong input of chose how to create initial line. Out of range.");
                    answer = gotAnswer;
                } else {
                    answer = gotAnswer;
                }
            } else {
                if (toCheck1.toLowerCase().equals("q")) {
                    globalFlag = false;
                } else {
                    System.out.println("Wrong input of chose how to use program.");
                }
            }
            if (globalFlag) {
                if (answer == 0) {
                    String stringToCheck = generator.generate();
                    System.out.println("Generated sequence:" + stringToCheck);
                    Recognizer recognizer = new Recognizer();
                    if (recognizer.nextState(stringToCheck) == 1) {
                        System.out.println("Recognizer recognized generated sequence");
                    } else {
                        System.out.println("Something went wrong");
                    }


                } else if (answer == 1) {

                    System.out.println("Enter sequence:");
                    String sequence = in.nextLine();

                    Recognizer recognizer = new Recognizer();
                    int got_state = recognizer.nextState(sequence);
                    if (got_state == 1) {
                        System.out.println("Your sequence was recognized");
                    } else if (got_state == 0) {
                        System.out.println("Your sequence was not recognized");
                    } else if (got_state == -1) {
                        System.out.println("Your sequence has words not from your language");
                    } else {
                        System.out.println("SMTH WENT WRONG");
                    }

                }
            }
        }
        System.out.println("Program ended successfully.");
    }
}