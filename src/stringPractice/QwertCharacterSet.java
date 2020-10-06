package stringPractice;

import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/change-string-to-a-new-character-set/
public class QwertCharacterSet {

    public static void main(String[] args) {
        String charSet = "qwertyuiopasdfghjklzxcvbnm";

        System.out.println(getEquivalentChar(charSet, "utta"));
        System.out.println(getEquivalentChar(charSet, "egrt"));
    }

    private static String getEquivalentChar(String charSet, String s) {
        String result = "";

        Map<Character, Character> mappedCharacterSet = new HashMap<>();

        for(int i = 0 ; i < charSet.length(); i ++){
            mappedCharacterSet.put(charSet.charAt(i), (char)((int)'a' + i));
        }

        for (Character c : s.toCharArray()){
            result += mappedCharacterSet.get(c);
        }
        return result;
    }
}
