package leetCode.hard.arrays;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumSumSubarrayofK {

    public static void main(String[] args) {
        int[] num = {-9361, -750, -8435, -5590, -5835, 2958, -3942, -8209, -8241, -9307, 7999, 9777,
                -6045, 1362, -4022, 7045, -1351, 9610, -4192, -267, -2120, 6657, -9405, -7549, 8074, 3222,
                -5563, 204, 2999, 3961, -6798, -53, 2349, -6533, -223, 1033, 7369, -6896, -1756, -127, 6161};
        int k = 3;
        MaximumSumSubarrayofK maximumSumSubarrayofK = new MaximumSumSubarrayofK();
      //  System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindowOptimized(num, 3)));

        //  System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindow(num, k)));
        // System.out.println(Arrays.toString(maximumSumSubarrayofK.getMaxSumSubArray(num, k)));

        num = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindowDeque(num, k)));

        /**  num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
         System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindow(num, k)));

         num = new int[]{9, 11};
         System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindow(num, 2)));

         num = new int[]{4, -2};
         System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindow(num, 2)));

         num = new int[]{1};
         System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindow(num, 1)));*/

        // num = new int[]{1, -1};
        System.out.println(Arrays.toString(maximumSumSubarrayofK.maxSlidingWindowOptimized(num, 3)));

    }

    //O(n*k) time complexity
    private int getMaxSumSubArraya(int[] num, int k) {
        int sum = 0, ans = 0;
        int slidingWindow;

        int j = 0;
        for (int i = 0; i < num.length && j < num.length; i++) {
            slidingWindow = k;
            sum = 0;
            j = i;
            while (slidingWindow > 0) {
                sum += num[j];
                slidingWindow--;
                j++;
            }

            ans = Math.max(sum, ans);
        }
        return ans;
    }

    private int[] getMaxSumSubArray(int[] nums, int k) {
        int sum = 0, maxSum = 0;
        int i = 0, j = 0;

        int[] result = new int[k];
        while (j < k) {
            sum += nums[j++];
        }

        maxSum = sum;

        while (j < nums.length) {
            sum += nums[j] - nums[j - k];
            if (sum > maxSum)
                i = j;
            maxSum = Math.max(sum, maxSum);

            j++;
        }

        while (k > 0) {
            result[--k] = nums[i--];
        }
        return result;
    }

    //528 ms
    private int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = 0, r = 0;

        int[] result = new int[nums.length - k + 1];
        while (j < k) {
            max = Math.max(max, nums[j++]);
        }

        result[r++] = max;

        while (j < nums.length) {
            if (nums[j] > max) {
                max = nums[j];
                result[r++] = nums[j];
            } else {
                if (max != (nums[j - k])) {
                    result[r++] = max;
                } else {
                    int window = k;
                    max = nums[j - window + 1];
                    while (window > 0) {
                        max = Math.max(nums[j - window + 1], max);
                        window--;
                    }
                    result[r++] = max;
                }
            }
            j++;
        }
        return result;
    }

    // 620ms solution
    public int[] maxSlidingWindowOptimized(int[] nums, int k) {
        if (nums == null)
            return new int[0];

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i + k - 1 < nums.length; i++) {
            int max = Integer.MIN_VALUE;
            if (i != 0 && result[i - 1] != nums[i - 1]) {
                max = Integer.max(result[i - 1], nums[i + k - 1]);
            } else {
                int end = i + k - 1;
                int start = i;
                while (start <= end)
                    max = Math.max(max, nums[start++]);

            }
            result[i] = max;
        }

        return result;
    }

    // 620ms solution
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int[] output = new int[nums.length - k + 1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            /* Whenever we move to a new window, discard previous window */
            if (!ad.isEmpty() && ad.peekFirst() == i - k) {
                ad.removeFirst();
            }

            /* If element pointed by current index is greater than elements pointed by previous index,
            discard previous indexes */
            while (!ad.isEmpty() && nums[ad.peekLast()] < nums[i]) {
                ad.removeLast();
            }

            /* Add the new index to the end of the ArrayDeque */
            ad.offer(i);


            /* When we find new window, we ll add the maximum in the window to the output */
            if (i + 1 >= k) {
                output[i + 1 - k] = nums[ad.peekFirst()];
            }
        }
        return output;
    }
}
