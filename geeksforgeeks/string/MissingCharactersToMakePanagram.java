package geeksforgeeks.string;

public class MissingCharactersToMakePanagram {

    public static void main(String[] args) {
        String nonPanagramStr = "The quick brown fox jumps over the lazy";
        System.out.println(missingCharToMakePanagram(nonPanagramStr));
    }

    private static String missingCharToMakePanagram(String s) {
        String result = "";
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

        for (int i = 0; i < panagramArr.length; i++) {
            if (panagramArr[i] == false) {
                result += (char) (i + (int) 'A');
            }
        }
        return result;
    }

}
