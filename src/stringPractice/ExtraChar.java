package stringPractice;

import java.util.HashSet;
import java.util.Set;

public class ExtraChar {

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "deabc";

        compareString(s1, s2);
        xorString(s1, s2);
        getExtraArrayCompareString(s1, s2);
    }

    private static void getExtraArrayCompareString(String s1, String s2) {
        int[] charArr = new int[256];
        char result = 0;
        for (char c : s1.toCharArray()) {
            charArr[c]++;
        }

        for (char c : s2.toCharArray()) {
            charArr[c]--;
        }

        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != 0) {
                result = (char) i;
            }
        }

        System.out.println(result);
    }

    private static void xorString(String s1, String s2) {
        int result = 0, i;

        for (i = 0; i < s1.length(); i++)
            result ^= s1.charAt(i);

        for (i = 0; i < s2.length(); i++)
            result ^= s2.charAt(i);

        System.out.println((char) result);
    }

    private static void compareString(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        char result = 'r';
        Set<Character> uniqueSet = new HashSet<>();

        if (s1Len < s2Len) {
            for (char c : s1.toCharArray()) {
                if (!uniqueSet.contains(c)) {
                    uniqueSet.add(c);
                }
            }
            for (char c : s2.toCharArray()) {
                if (!uniqueSet.contains(c))
                    result = c;
            }
        } else {
            for (char c : s2.toCharArray()) {
                if (!uniqueSet.contains(c)) {
                    uniqueSet.add(c);
                }
            }
            for (char c : s1.toCharArray()) {
                if (!uniqueSet.contains(c))
                    result = c;
            }
        }

        System.out.println(result);
    }
}
