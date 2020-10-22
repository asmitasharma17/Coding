package leetCode.easy.string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split.length > 0 ? split[split.length-1].length() : 0;
    }

    public static void main(String[] args) {
        String input = "Hello     World    ";
        LengthOfLastWord lastWord = new LengthOfLastWord();
        System.out.println(lastWord.lengthOfLastWord(input));
    }

    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
     *
     * If the last word does not exist, return 0.
     *
     * Note: A word is defined as a maximal substring consisting of non-space characters only.
     *
     * Example:
     *
     * Input: "Hello World"
     * Output: 5
     */
}
