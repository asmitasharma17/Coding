package geeksforgeeks.string;

public class ReverseString {

    public static void main(String[] args) {

        String word = "abc";
        getReverseStringUsing2Pointers(word);

        char[] charArr = word.toCharArray();
        reverseStringWithoutExtraMemory(charArr);
        // This is a string in which a character
        // to be searched.
        String str = "GeeksforGeeks is a computer science portal";

        // Returns index of first occurrence of character.
        int firstIndex = str.indexOf('s');
        System.out.println("First occurrence of char 's'" +
                " is found at : " + firstIndex);

        // Returns index of last occurrence specified character.
        int lastIndex = str.lastIndexOf('s');
        System.out.println("Last occurrence of char 's' is" +
                " found at : " + lastIndex);

        // Index of the first occurrence of specified char
        // after the specified index if found.
        int first_in = str.indexOf('s', 10);
        System.out.println("First occurrence of char 's'" +
                " after index 10 : " + first_in);

        int last_in = str.lastIndexOf('s', 13);
        System.out.println("Last occurrence of char 's'" +
                " after index 20 is : " + last_in);

        // gives ASCII value of character at location 20
        int char_at = str.charAt(20);
        System.out.println("Character at location 20: " +
                char_at);

        // throws StringIndexOutOfBoundsException
        // char_at = str.charAt(50);
    }

    private static void getReverseStringUsing2Pointers(String word) {
        char[] tempArr = word.toCharArray();
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            char temp = tempArr[i];
            tempArr[i] = tempArr[j];
            tempArr[j] = temp;
        }
        System.out.println(tempArr);
    }

    private static void reverseStringWithoutExtraMemory(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j] ;
            s[j] = temp;
        }
        System.out.println(s);
    }
}
