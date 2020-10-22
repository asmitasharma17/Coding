package leetCode.easy.arrays;

public class Sqrt {

    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }

    public static void main(String[] args) {
        int x = 4290;
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(x));
    }
}
