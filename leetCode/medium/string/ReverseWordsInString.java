package leetCode.medium.string;

public class ReverseWordsInString {

    //8ms
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split("\\s+");

        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i] != "")
                sb.append(split[i] + " ");
        }

        return sb.toString().trim();
    }

    //1 ms
    public String reverseWords(String s) {
        StringBuilder rev = new StringBuilder();
        int end = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) != ' ') {
                end = i;
                i = s.lastIndexOf(' ', end);
                rev.append(s.substring(i + 1, end + 1)).append(' ');
            }
        }
        return rev.toString().trim();
    }

    public static void main(String[] args) {
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords("the sky is blue"));
        System.out.println(reverseWordsInString.reverseWords("  hello    world  "));
        System.out.println(reverseWordsInString.reverseWords("a good   example"));
        System.out.println(reverseWordsInString.reverseWords("  Bob    Loves  Alice  "));
    }

    /**
     * Reverse Words in a String
     * Given an input string s, reverse the order of the words.
     *
     * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
     *
     * Return a string of the words in reverse order concatenated by a single space.
     *
     * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "the sky is blue"
     * Output: "blue is sky the"
     * Example 2:
     *
     * Input: s = "  hello world  "
     * Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     *
     * Input: s = "a good   example"
     * Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     * Example 4:
     *
     * Input: s = "  Bob    Loves  Alice   "
     * Output: "Alice Loves Bob"
     * Example 5:
     *
     * Input: s = "Alice does not even like bob"
     * Output: "bob like even not does Alice"
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s contains English letters (upper-case and lower-case), digits, and spaces ' '.
     * There is at least one word in s.
     * https://leetcode.com/problems/reverse-words-in-a-string/
     */
}
