package leetCode.easy.bits;

public class ReverseBits {

    public int reverseBits(int n) {
        int rev = 0;
        while (n > 0) {
            rev <<= 1;
            if ((int) (n & 1) == 1)
                rev ^= 1;

            n >>= 1;
        }
        return Integer.parseInt(String.valueOf(rev), 2);
    }

    public static void main(String[] args) {
        //int n = Integer.parseInt("00000010100101000001111010011100", 2);
        int n = Integer.parseInt("1100", 2);
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(n));
    }
}
