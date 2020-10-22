package geeksforgeeks.string;

//https://www.geeksforgeeks.org/round-the-given-number-to-nearest-multiple-of-10/

public class RoundUpNumbe {

    public static void main(String[] args) {
        int s = 38;
        System.out.println(getRoundUpNumber(s));

        s = 4048;
        System.out.println(getRoundUpNumber(s));
    }

    private static int getRoundUpNumber(int n) {
        int a = (n / 10) * 10;
        int b = a + 10;

        if (n - a > b - n)
            return b;
        else
            return a;
    }
}
