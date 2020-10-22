package leetCode.easy.string;

public class ReverseVowels {

    public String reverseVowels(String s) {
        String vowel = "aeiou";
        int i = 0, j = s.length() - 1;
        char[] sArr = s.toCharArray();
        while (i < j) {
            char temp;
            if (vowel.indexOf(sArr[i]) == -1) {
                i++;
                continue;
            }
            if (vowel.indexOf(sArr[j]) == -1) {
                j--;
                continue;
            }

            temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(sArr);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ReverseVowels rv = new ReverseVowels();
        System.out.println(rv.reverseVowels(s));
    }
}
