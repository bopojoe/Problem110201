import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author James O'Rourke_20074556
 * @file Problem1101201
 * @assignment Problem110201 Assignment
 * @brief This app is built to solve the Jolly Jumper problem
 * @notes This program does check for a max value but will not end if it is over,
 * instead it prints "Not jolly".(Personally I would capitalise the "j" but that was not to spec)
 * it is roughly 100 lines of code
 */

public class Problem110201 {

    private Scanner input;
    private LinkedList<int[]> list = new LinkedList<>();
    private int count = 0;
    private int maxValue = 3000;
    private int[] inputNumbers;
    private String[] inputString;
    private int amountOfNumbers;
    private boolean nullTest = true;

    //builds scanner and runs program
    public Problem110201() {
        input = new Scanner(System.in);
        run();
    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        Problem110201 app = new Problem110201();
    }

    //the run sequence of the program
    private void run() {
        inputs();
        outputs(jollyChecker());
        exitApp();
    }

    //this takes the the first line, splits it into a string array,
// which is then parsed into an int array without the first number
// it also uses the first number to set the size of the array so if this is the wrong size it catches the exception
// it then adds the array to a linked list to call back later
    private void inputs() {
        while (nullTest) {
            inputString = input.nextLine().split(" ");
            if (inputString[0].equals("")) {
                nullTest = false;
            } else {
                int counter = Integer.parseInt(inputString[0]);
                try {
                    inputNumbers = new int[counter];
                    for (int i = 0; i < counter; i++) {
                        inputNumbers[i] = Integer.parseInt(inputString[i + 1]);
                    }
                } catch (Exception ArrayIndexOutOfBoundsException) {
                }
                list.add(inputNumbers);
                count++;
            }
        }
    }

    //this method gets the input numbers from the linked list and iterates over them whilst checking the differences
// and adding them to an ArrayList, if the check is false it skips that number and thus the arrayList size is wrong
// and the answer will be "Not jolly"
    private String[] jollyChecker() {
        String[] jollyAnswers = new String[count];
        ArrayList<Integer> jollyDifference;
        for (int i = 0; i < count; i++) {
            int[] currentList = list.get(i);
            amountOfNumbers = currentList.length;
            jollyDifference = new ArrayList();
            if (amountOfNumbers <= maxValue) {
                for (int j = 0; j < amountOfNumbers - 1; j++) {
                    int one = currentList[j];
                    int two = currentList[j + 1];
                    int valueToTest = Math.abs(two - one);
                    if ((valueToTest > 0 && valueToTest <= amountOfNumbers - 1) && (!checkArray(jollyDifference, valueToTest))) {
                        jollyDifference.add(valueToTest);
                    }
                }
                if (jollyDifference.size() == (amountOfNumbers - 1)) {
                    jollyAnswers[i] = "Jolly";
                } else {
                    jollyAnswers[i] = "Not jolly";
                }
            } else {
                jollyAnswers[i] = "Not jolly";
            }

        }
        return jollyAnswers;
    }

    //checks if the ArrayList contains the Integer in Question
    private boolean checkArray(ArrayList testArray, int testValue) {
        for (int i = 0; i < testArray.size(); i++) {
            if (testArray.contains(testValue)) {
                return true;
            }
        }
        return false;
    }

    //cycles the array and prints the String values
    private void outputs(String[] str) {
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }

    //method to nicely exit the app
    private void exitApp() {

        System.exit(0);
    }
}
