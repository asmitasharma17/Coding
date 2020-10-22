package leetCode.easy.arrays;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class MajorityElement {

    //9 ms
    public int majorityElement(int[] nums) {
        Map<Integer, Long> collect = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));
        long max = 0;
        long result = 0;
        for (Map.Entry<Integer, Long> entry : collect.entrySet()) {
            if (max < entry.getValue()) {
                max = Math.max(max, entry.getValue());
                result = entry.getKey();
            }
        }
        return (int) result;
    }

    //10 ms
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length == 1) return nums[0];
            else if (i != 0 && nums[i] == nums[i - 1]) {
                count++;
                if (count > nums.length/2) return nums[i];
            } else
                count = 1;
        }
        return 0;
    }

    // use information majrity element is more than floor[n/2]
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums[0];
        int limit = nums.length / 2;

        for (int num : nums) {
            if (num == n) {
                count++;
                if (count > limit) {
                    return n;
                }
                continue;
            } else {
                count = 1;
                n = num;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement1(nums));
    }

    public static void print(List<Boolean> nums) {
        for (Boolean i : nums)
            System.out.print(i.booleanValue() + " ");
        System.out.println();
    }
    /**
     * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * You may assume that the array is non-empty and the majority element always exist in the array.
     *
     * Example 1:
     *
     * Input: [3,2,3]
     * Output: 3
     * Example 2:
     *
     * Input: [2,2,1,1,1,2,2]
     * Output: 2
     * https://leetcode.com/problems/majority-element/
     */
}
