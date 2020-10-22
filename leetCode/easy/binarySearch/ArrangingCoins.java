package leetCode.easy.binarySearch;

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        int temp = n;
        for (int i = 0; i < temp; i++) {
            if (n < (i + 1))
                return i;
            else if (n == (i + 1))
                return i + 1;

            n = n - (i + 1);
        }
        return 0;
    }

    public int arrangeCoins1(int n) {
        int i=0;
        while (n>=0) {
            i++;
            n = n-i;
        }
        return i-1;
    }

    public int arrangeCoinsUsingBinarySearch(int n) {
        long left = 0, right = n;
        while (left <= right) {
            long k = left + (right - left) / 2;
            long curr = k * (k + 1) / 2;

            if (n == curr)
                return (int)k;
            if (n < curr)
                right = k - 1;
            else
                left = k + 1;
        }
        return (int) right;
    }

    public static void main(String[] args) {
        int n = 8;
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        int result = arrangingCoins.arrangeCoinsUsingBinarySearch(n);
        System.out.println(result);
    }

    /**
     You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

     Given n, find the total number of full staircase rows that can be formed.

     n is a non-negative integer and fits within the range of a 32-bit signed integer.

     Example 1:

     n = 5

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤

     Because the 3rd row is incomplete, we return 2.
     Example 2:

     n = 8

     The coins can form the following rows:
     ¤
     ¤ ¤
     ¤ ¤ ¤
     ¤ ¤

     Because the 4th row is incomplete, we return 3.
     https://leetcode.com/problems/arranging-coins/
     */
}
