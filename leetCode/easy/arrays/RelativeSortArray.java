package leetCode.easy.arrays;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //prepare map
        Map<Integer, Long> freq1 = Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(Integer::intValue, TreeMap::new, Collectors.counting()));

        int[] result = new int[arr1.length];
        Long count = 0l;
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            count = freq1.get(arr2[i]);
            while (count > 0) {
                result[j++] = arr2[i];
                count--;
            }
        }

        Set<Map.Entry<Integer, Long>> entries = freq1.entrySet();

        boolean matched = false;
        for (Map.Entry<Integer, Long> entry : entries) {
            if (entry.getKey() == arr2[arr2.length - 1]) {
                matched = true;
            }

            int exitedElement = IntStream.range(0, result.length)
                    .filter(i -> entry.getKey() == result[i])
                    .findFirst() // first occurrence
                    .orElse(-1); // No element found

            if (exitedElement == -1 && entry.getKey() != arr2[arr2.length - 1] && matched) {
                Long valueCount = entry.getValue();
                while (valueCount > 0) {
                    result[j++] = entry.getKey();
                    valueCount--;
                }
            }
        }

        Arrays.sort(arr1);
        for (; j < arr1.length; j ++) {
            for (Map.Entry<Integer, Long> entry : entries) {

            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {26,21,11,20,50,34,1,18};
        int[] arr2 = {21,11,26,20}; //output : [[21,11,26,20,1,18,34,50]]
        RelativeSortArray rsa = new RelativeSortArray();
        print(rsa.relativeSortArray(arr1, arr2));
    }

    public static void print(int[] result) {
        System.out.println(Arrays.toString(result));
    }

    /**
     * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
     *
     * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
     *
     *
     *
     * Example 1:
     *
     * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
     * Output: [2,2,2,1,4,3,3,9,6,7,19]
     *
     *
     * Constraints:
     *
     * arr1.length, arr2.length <= 1000
     * 0 <= arr1[i], arr2[i] <= 1000
     * Each arr2[i] is distinct.
     * Each arr2[i] is in arr1.
     *
     * https://leetcode.com/problems/relative-sort-array/
     */
}
