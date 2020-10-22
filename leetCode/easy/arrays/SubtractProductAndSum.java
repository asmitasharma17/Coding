package leetCode.easy.arrays;

public class SubtractProductAndSum {

    public int subtractProductAndSum(int n) {
        int[] k = new int[Integer.toString(n).length()];
        int i = 0 ;
        int product = 1, sum = 0;

        while (i >= 0 && n > 0){
            k[i] = n%10;
            n /= 10;
            i++;
        }

       while (i>0){
            product *= k[--i];
            sum += k[i];
        }

        return product - sum;
    }

    public static void main(String[] args) {
        int n = 4421;
        SubtractProductAndSum subtractProductAndSum = new SubtractProductAndSum();
        System.out.println(subtractProductAndSum.subtractProductAndSum(n));
    }

    /**
     * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
     *
     *
     * Example 1:
     *
     * Input: n = 234
     * Output: 15
     * Explanation:
     * Product of digits = 2 * 3 * 4 = 24
     * Sum of digits = 2 + 3 + 4 = 9
     * Result = 24 - 9 = 15
     * Example 2:
     *
     * Input: n = 4421
     * Output: 21
     * Explanation:
     * Product of digits = 4 * 4 * 2 * 1 = 32
     * Sum of digits = 4 + 4 + 2 + 1 = 11
     * Result = 32 - 11 = 21
     *
     *
     * Constraints:
     *
     * 1 <= n <= 10^5
     * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
     */
}
