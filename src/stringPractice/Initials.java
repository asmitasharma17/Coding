package stringPractice;

public class Initials {

    public static void main(String[] args) {
        String s = "asmita sharma";
        System.out.println(getInitials(s));

    }

    private static String getInitials(String s) {
        String result = "";

        String[] split = s.split(" ");
        for (String i : split) {
            result += Character.toUpperCase(i.charAt(0)) + " ";
        }

        return result.strip();
    }
}
