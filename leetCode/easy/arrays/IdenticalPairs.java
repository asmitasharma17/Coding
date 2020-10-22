package leetCode.easy.arrays;

import java.util.HashMap;
import java.util.Map;

public class IdenticalPairs {

    //1 ms
    public int numIdenticalPairs1(int[] nums) {
        int identicalPairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    identicalPairs++;
            }
        }

        return identicalPairs;
    }

    // 0 ms
    public int numIdenticalPairs(int[] nums) {
        int identicalPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                identicalPairs += map.get(nums[i]);
            } else {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        return identicalPairs;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        IdenticalPairs ip = new IdenticalPairs();
        System.out.println(ip.numIdenticalPairs(nums));
    }
}
