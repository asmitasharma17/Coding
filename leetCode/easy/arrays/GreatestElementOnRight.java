package leetCode.easy.arrays;

public class GreatestElementOnRight {

    // travserse from left, and save max everytime.
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = arr[len - 1];
        int newMax = max;
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            newMax = arr[i];
            arr[i] = max;
            max = Math.max(newMax, max);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17, 18, 5, 4, 6, 1}; //output 18,6,6,6,1,-1]
        GreatestElementOnRight re = new GreatestElementOnRight();
        print(re.replaceElements(arr));
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
     *
     * After doing so, return the array.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [17,18,5,4,6,1]
     * Output: [18,6,6,6,1,-1]
     *
     *
     * Constraints:
     *
     * 1 <= arr.length <= 10^4
     * 1 <= arr[i] <= 10^5
     * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
     */
}
