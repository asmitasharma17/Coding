package geeksforgeeks.string;

public class RemovePunctuations {

    public static void main(String[] args) {
        String s = "%welcome' to @geeksforgeek<s";
        System.out.println(getRemovePunctuations(s));

        String s1 = "Hello!!!, he said ---and went.";
        System.out.println(getRemovePunctuations(s1));
    }

    private static String getRemovePunctuations(String s) {
       return s.replaceAll("\\p{Punct}", "");
    }
}