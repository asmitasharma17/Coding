package leetCode.easy.arrays;

import java.util.*;

public class AddSum {

    /** 39 ms solution
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
**/

    //1 ms solution
   /** public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (resultMap.containsKey(target - nums[i])) {
                return new int[]{resultMap.get(target - nums[i]), i};
            } else {
                resultMap.put(nums[i], i);
            }
        }
        return new int[2];
    }
    **/

    //4ms solution where we assume, a number can have multiple sums,
   public static int[] twoSum(int[] nums, int target) {
       HashMap<Integer, List<Integer>> resultMap = new HashMap<>();
       for (int index = 0; index < nums.length; index++) {
           resultMap.putIfAbsent(nums[index], new ArrayList<>());
           resultMap.get(nums[index]).add(index);
           if (resultMap.containsKey(target - nums[index])) {
               int finalIndex = index;
               List<Integer> list = resultMap.get(target - nums[index]);
               Optional<Integer> optional = list.stream().filter(x -> !x.equals(finalIndex)).findFirst();
               if (optional.isPresent() && optional.get() != index) {
                   return new int[]{optional.get(), finalIndex};
               }
           }
       }
       return new int[]{-1, -1};
   }

    public static void main(String[] args) {
       //int[] nums = new int[]{2, 7, 11, 15}; int target = 9;
        int[] nums = new int[]{3,2,4}; int target = 6;
        //int[] nums = new int[]{3,3}; int target = 6;

        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * https://leetcode.com/problems/two-sum/
     */
}
