package geeksforgeeks.string;

import java.util.Stack;

public class PatternOccurences {

    public static void main(String[] args) {
        String input = "ABABCABCC";
        String pattern = "ABC";
        getPatternOccurnces(input, pattern);
    }

    private static void getPatternOccurnces(String input, String pattern) {
        int count = 0;
        char[] stackArr = new char[input.length()];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == pattern.charAt(i)) {
                count++;
            } else {
                count = 0;
            }
            stackArr[i] = input.charAt(i);
            stack.push(input.charAt(i));
            if(count == pattern.length())
            {
                System.out.print("Found occurences at : " + i);
                while (count !=0)
                    stack.pop();
            }

            
            

        }

    }
}
