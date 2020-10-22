package leetCode.easy.arrays;

public class Palindrome {

    // 7 ms
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(int x) {
        long reversed = 0;
        int input = x;
        while (x > 0) {
            reversed = 10 * reversed + (x % 10);
            x /= 10;
        }
        if (input == (int) reversed) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome2(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        int x = 101;
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome2(x));
    }
}
