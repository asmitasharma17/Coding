package stringPractice;

public class DuckNumer {

    public static void main(String[] args) {
        String s = "00002364";
        System.out.println(getDuckNumber(s));

        s = "707069";
        System.out.println(getDuckNumber(s));
    }

    private static boolean getDuckNumber(String s) {

        int i = 0, n = s.length();
        while (i < n && s.charAt(i) == '0')
            i++;

        for (; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                return true;
        }
        return false;
    }

}
