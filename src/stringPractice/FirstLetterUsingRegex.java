package stringPractice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstLetterUsingRegex {
    public static void main(String[] args) {
        String s = "Geeks for geeksGeeks for geeks";
        String regex = "\\b[a-zA-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(s);

        while (m.find())
            System.out.print(m.group());
    }
}
