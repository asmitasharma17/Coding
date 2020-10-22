package leetCode.easy.arrays;

import java.util.ArrayList;
import java.util.List;

public class GreatestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> resultList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max)
                resultList.add(true);
            else
                resultList.add(false);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 1, 3};
        int extraCandies = 3;//output = 2,
        GreatestCandies me = new GreatestCandies();
        print(me.kidsWithCandies(nums, extraCandies));
    }

    public static void print(List<Boolean> nums) {
        for (Boolean i : nums)
            System.out.print(i.booleanValue() + " ");
        System.out.println();
    }
}
