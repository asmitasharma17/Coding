package geeksforgeeks.string;

import java.util.regex.Pattern;

public class ReverseWordsUSingRegex {

    public static void main(String[] args) {
        String input = "Welcome to geeksforgeeks";
        //Output : "geeksforgeeks to Welcome";
        getReverseWords(input);
        input = "I love Java Programming";
        //Output :"Programming Java love I";
        getReverseWords(input);
    }

    private static void getReverseWords(String input) {
        String regex = "\\s";
        Pattern p = Pattern.compile(regex);
        String[] word = p.split(input);

        String result = "";

        for(int i = word.length-1; i>=0 ; i--){
            result+= word[i] + " ";
        }

        System.out.println(result);
    }
}
