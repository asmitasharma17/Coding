package geeksforgeeks.string;

public class PanagramString {
    public static void main(String[] args) {
        String panagramStr = "The quick brown fox jumps over the lazy dog";
        System.out.println(getCheckPanagram(panagramStr));
        String nonPanagramStr = "The quick brown fox jumps over the lazy";
        System.out.println(getCheckPanagram(nonPanagramStr));
    }

    private static boolean getCheckPanagram(String s) {

        boolean result = true;
        int index = 0;

        boolean[] panagramArr = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') {
                index = s.charAt(i) - 'A';
            } else if ('a' <= s.charAt(i) && s.charAt(i) <= 'z') {
                index = s.charAt(i) - 'a';
            } else
                continue;

            panagramArr[index] = true;
        }

        for (boolean b : panagramArr) {
            if (!b)
                result = false;
        }

        return result;
    }


}
