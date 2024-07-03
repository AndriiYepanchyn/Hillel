package main.java.lesson_05;
import main.java.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lesson_05_Basic_algorithm_tasks {
	private static String lessonName = "Lesson_05_Basic_algorithm_tasks".replace('_', ' ').toUpperCase();
    private static final String TASK01 = "There is a rectangle field of cells, and a robot is situated in a center of field. The robot can move for 1 cell in four directions:\n"
	+ "R (right), L (left), U (up), and D (down).\n" 
    + "Input string describes robot path \"UUDLDR\". Method returns true then robot will come back to the initial cell after he pass the route, return false otherwise.\n" 
	+ "For example:\nInput: \"UD\"\nOutput: true \nInput: \"LL\"\nOutput: false ";
    private static final String TASK02 = "Check does the number is simple. Return true if number is simple, return false otherwise";
    private static final String TASK03 = "Write the method which having input params: sorted array and number. Method implements binary search and returns true if array contains the number, return false otherwise";
    private static final String TASK04 = "Write recursive method which returns all combinations of latters in input string.\n" + 
	"For example abc: abc, acb, bac, bca, cab, cba";

    private static List<Integer> dividers;

    public static void run() {
        Utils utils = new Utils();
        System.out.println(Utils.wrapMessage(lessonName, true,'*','*', '*'));
        utils.execute(TASK01, Lesson_05_Basic_algorithm_tasks::task01);
        utils.execute(TASK02, Lesson_05_Basic_algorithm_tasks::task02);
        utils.execute(TASK03, Lesson_05_Basic_algorithm_tasks::task03);
        utils.execute(TASK04, Lesson_05_Basic_algorithm_tasks::task04);

    }

    private static void task01() {
        System.out.println("Enter route for Robot");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println("You entered next route for Robot:  " + input);
        String r = convertRoute(input);
        System.out.println("Robot route is converted for:   " + r + "\n");
        System.out.println("Will Robot come back?  " + isRoboBack(r) + "\n");
    }

    private static void task02() {
        int inputInt = 0;
        Scanner scanner = new Scanner(System.in);
        while (inputInt <= 1) {
            System.out.println("Enter int number >1");
            inputInt = scanner.nextInt();
        }

        if (isNumberSimple(inputInt)) {
            System.out.println(inputInt + " is simple.");
        } else {
            System.out.println(inputInt + " is complicated, it divides on:\n");
            System.out.println(dividers.toString());
        }

    }

    private static void task03() {
        int[] inArray = {1, 2, 3, 4};
        System.out.print(Arrays.toString(inArray));
        System.out.println();
        System.out.println("Input search value");
        Scanner scanner = new Scanner(System.in);
        int inputInt = scanner.nextInt();
        System.out.println(binarySearch(inArray, inputInt));

    }

    private static void task04() {
        System.out.println("Input string");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        ArrayList<String> outputList = new ArrayList<>();
        findPermutations(inputString, outputList);
        System.out.println("Permutations: "+ outputList);
    }

    //      Helpers for the  task01
    static boolean isRoboBack(String r) {
        boolean answer = false;
        int currentX = 0;
        int currentY = 0;
        for (int i = 0; i < r.length(); i++) {
            switch (r.charAt(i)) {
                case 'u':
                    currentY++;
                    break;
                case 'd':
                    currentY--;
                    break;
                case 'l':
                    currentX--;
                    break;
                case 'r':
                    currentX++;
                    break;
                default:
                    System.out.println("something wrong: " + "X= " + currentX + "; Y= " + currentY);
                    break;
            }
        }

        if (currentX == 0 && currentY == 0) {
            answer = true;
        }
        return answer;
    }

    static String convertRoute(String route) {
        String convertedRoute = route.toLowerCase();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < route.length(); i++) {
            switch (convertedRoute.charAt(i)) {
                case 'u':
                case 'd':
                case 'l':
                case 'r':
                    result.append(convertedRoute.charAt(i));
            }
        }
        return result.toString();
    }

    //       Helper for the task02
    static boolean isNumberSimple(int inputInt) {
        dividers = new ArrayList<>();
        boolean answer = false;
//To define is number is simple enough set max limit as Math.sqrt(). But to get all dividers we should check all numbers up to value/2. 
        for (int index = 1; index < inputInt / 2 + 1; index++) {
            if (inputInt % index == 0) {
                dividers.add(index);
            }
        }
        if (dividers.size() < 2) {
            answer = true;
        }
        return answer;
    }

    //        Helper to task03
    public static boolean binarySearch(int[] arr, int value) {
        boolean answer = false;
        int last = arr.length - 1;
        int first = 0;
        int mid =  (last + 1) / 2;
        while (last - first > 1) {
            if (value < arr[first] || value > arr[last]) {
                return false;
            } else if (arr[mid] == value) {
                return true;
            } else if (arr[mid] < value) {
                first = mid + 1;
                mid =  (last + first) / 2;
            } else {
                last = mid - 1;
                mid = (last + first) / 2;
            }
        }
        if (arr[last] == value || arr[first] == value) {
            answer = true;
        }
        return answer;
    }

    //        Helper for task04
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void permutations(char[] chars, int currentIndex, ArrayList<String> saveTo) {
        if (currentIndex == chars.length - 1) {
            saveTo.add(String.valueOf(chars));
        }

        for (int i = currentIndex; i < chars.length; i++) {
            swap(chars, currentIndex, i);
            permutations(chars, currentIndex + 1, saveTo);
            swap(chars, currentIndex, i);
        }
    }

    public static void findPermutations(String str, ArrayList<String> saveTo) {
        if (str == null || str.length() == 0) {
            return;
        }
        permutations(str.toCharArray(), 0, saveTo);
    }
}