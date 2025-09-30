package Task1;
import java.util.Arrays;
public class DigitsDescending {

    /**
     * Function to rearrange digits of a non-negative integer
     * in descending order to form the maximum possible value.
     *
     * @param num The input non-negative integer
     * @return The integer with digits sorted in descending order
     */
    public static int sortDigitsDescending(int num) {
        // Convert the number into a character array
        char[] digits = String.valueOf(num).toCharArray();

        // Sort digits in ascending order
        Arrays.sort(digits);

        // Reverse to get descending order
        StringBuilder sb = new StringBuilder(new String(digits));
        sb.reverse();

        // Convert back to integer
        return Integer.parseInt(sb.toString());
    }

    // Main method to demonstrate the function
    public static void main(String[] args) {
        int input1 = 42145;
        int result1 = sortDigitsDescending(input1);
        System.out.println("Input: " + input1 + " → Output: " + result1);

        int input2 = 145263;
        int result2 = sortDigitsDescending(input2);
        System.out.println("Input: " + input2 + " → Output: " + result2);
    }
}
