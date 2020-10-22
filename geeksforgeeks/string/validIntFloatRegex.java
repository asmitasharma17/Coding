package geeksforgeeks.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validIntFloatRegex {

    public static void main(String[] args) {

        String input1 = "abc";
        String input2 = "1234";

        getValidIntNumber(input1);
        getValidIntNumber(input2);

        String float1 = "10e5.4";
        String float2 = "2e10";

        getValidFloatNumber(float1);
        getValidFloatNumber(float2);
    }

    private static void getValidFloatNumber(String i) {
        String regex = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(i);

        if(m.find() && m.group().equals(i))
            System.out.println("Valid float " + i);
        else
            System.out.println("Invalid float " + i);
    }

    private static void getValidIntNumber(String i) {
        String regex = "[+-]?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(i);

        if(m.find() && m.group().equals(i))
            System.out.println("Valid int " + i);
        else
            System.out.println("Invalid int " + i);
    }
}
