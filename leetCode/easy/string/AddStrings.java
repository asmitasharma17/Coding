package leetCode.easy.string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        String result = "";
        StringBuilder result1 = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            carry += i >= 0 ? num1.charAt(i) - '0' : 0;
            carry += j >= 0 ? num2.charAt(j) - '0' : 0;

            result1.append((carry % 10));
            carry /= 10;
            i--;
            j--;
        }

        return result1.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "1234";
        String num2 = "123456";
        AddStrings as = new AddStrings();
        System.out.println(as.addStrings(num1, num2));
    }
}
