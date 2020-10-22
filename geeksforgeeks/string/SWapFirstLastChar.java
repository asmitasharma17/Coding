package geeksforgeeks.string;

public class SWapFirstLastChar {

    public static void main(String[] args) {
        System.out.println(swapFirstandLastChar("geeks for geeks"));
    }

    private static String swapFirstandLastChar(String str) {
        String result = "";
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            int k = i;

            while (i < ch.length && ch[i] != ' ')
                i++;

            char temp = ch[k];
            ch[k] = ch[i - 1];
            ch[i - 1] = temp;
        }
        return new String(ch);
    }
}
