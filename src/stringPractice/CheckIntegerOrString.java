package stringPractice;

public class CheckIntegerOrString {

    public static void main(String[] args) {

        String s = "127";

        System.out.println(isNumber(s));

        s = "126.98";

        System.out.println(isNumber(s));
    }

    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
