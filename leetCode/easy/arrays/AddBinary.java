package leetCode.easy.arrays;

public class AddBinary {

    public String addBinary(String a, String b) {
        String result = "";
        int digit = 0;
        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0 || digit == 1) {
            digit += (i >= 0) ? a.charAt(i) - '0' : 0;
            digit += (j >= 0) ? b.charAt(j) - '0' : 0;

            result = (char) (digit % 2 + '0') + result;
            digit /= 2;
            i--; j--;
        }

        return result;
    }

    public static void main(String[] args) {
        String a = "11", b = "1"; // "100"
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));

        a = "1010";
        b = "1011"; // Output: "10101"
        System.out.println(addBinary.addBinary(a, b));

        a = "1010";
        b = "1111"; // Output: "11101"
        System.out.println(addBinary.addBinary(a, b));

        a = "1";
        b = "111"; // Output: "1000"
        System.out.println(addBinary.addBinary(a, b));
    }

    /**
     * Given two binary strings, return their sum (also a binary string).
     *
     * The input strings are both non-empty and contains only characters 1 or 0.
     *
     * Example 1:
     *
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     *
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     *
     * Constraints:
     *
     * Each string consists only of '0' or '1' characters.
     * 1 <= a.length, b.length <= 10^4
     * Each string is either "0" or doesn't contain any leading zero.
     * https://leetcode.com/problems/add-binary/
     */
}
