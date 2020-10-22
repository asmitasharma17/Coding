package leetCode.hard.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountSmaller {

    // do it again with BST, mergeSort,binary search
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < nums.length; i++)
        {
            int count= 0;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]> nums[j])
                    count++;
            }
            result.add(count);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1}; //[2,1,1,0]
        CountSmaller countSmaller = new CountSmaller();
        countSmaller.printArray(countSmaller.countSmaller(nums));
    }

    void printArray(List<Integer> nums) {
        for (int i : nums)
            System.out.print(i + " ");
        System.out.println();
    }

    /**
     * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [5,2,6,1]
     * Output: [2,1,1,0]
     * Explanation:
     * To the right of 5 there are 2 smaller elements (2 and 1).
     * To the right of 2 there is only 1 smaller element (1).
     * To the right of 6 there is 1 smaller element (1).
     * To the right of 1 there is 0 smaller element.
     *
     * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
     */
}
