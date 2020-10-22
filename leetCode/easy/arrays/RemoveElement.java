package leetCode.easy.arrays;

public class RemoveElement {

    public int removeElement1(int[] nums, int val) {
        int i = 0, j = 0;
        int temp;
        while (i < nums.length && j < nums.length) {
            while (j < nums.length && nums[j] == val) {
                j++;
                if(j < nums.length && nums[i] != nums[j]) {
                    break;
                }
            }

            if (i != j && j > i && j < nums.length && nums[i] != nums[j]) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
            if (j < i)
                j = i ;
        }

        for (i = 0 ; i < nums.length ;)
        {
            if(nums[i] != val)
            {
                i++;
            }
            else
            {
                break;
            }
        }
        return i;
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        RemoveElement re = new RemoveElement();
        int len = re.removeElement(nums, val);
        print(nums, len);

        nums = new int[]{2, 3, 2, 3};
        val = 2;
        len = re.removeElement(nums, val);
        print(nums, len);
    }


    public static void print(int[] nums, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *
     * Example 1:
     *
     * Given nums = [3,2,2,3], val = 3,
     *
     * Your function should return length = 2, with the first two elements of nums being 2.
     *
     * It doesn't matter what you leave beyond the returned length.
     * Example 2:
     *
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,
     *
     * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
     *
     * Note that the order of those five elements can be arbitrary.
     *
     * It doesn't matter what values are set beyond the returned length.
     * https://leetcode.com/problems/remove-element/
     */
}
