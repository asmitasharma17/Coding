package leetCode.medium.string;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring1(String s) {
        int count = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();

        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                count = Math.max(count, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return count;
    }

    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        char[] strCh = s.toCharArray();
        String maxString = "";

        //abbacd
        for(int i=0; i<strCh.length ; i++) {
            //ts.add(strCh[i]+"");
            String newString = "";
            //newString += strCh[i]+"";
            newString.concat((strCh[i]) + "");

            if (strCh[i] + "" != strCh[++i] + "") {
                newString.concat((strCh[i]) + "");
            } else {
                System.out.println(maxString);
                System.out.println(newString);
                if (maxString.length() < newString.length()) {
                    maxString = newString;
                }
            }

        }
        return maxString.length();
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lo = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("length of abcabcbb is " + lo.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("length of bbbbb is " + lo.lengthOfLongestSubstring("bbbbb"));
        System.out.println("length of pwwkew is " + lo.lengthOfLongestSubstring("pwwkew"));
        System.out.println("length of  is " + lo.lengthOfLongestSubstring(""));
    }

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     *
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * Example 4:
     *
     * Input: s = ""
     * Output: 0
     *
     *
     * Constraints:
     *
     * 0 <= s.length <= 5 * 104
     * s consists of English letters, digits, symbols and spaces.
     */
}
