package leetCode.easy.arrays;

import java.util.*;

public class SumArrayForm {
    //approach takes 1 ms.
    public List<Integer> addToArrayForm1(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int i = A.length - 1, carry =0;
        while (i >=0 && K>0){
            //int[] A = new int[]{2,1,5}; int K = 806; // Output: [1,0,2,1]
            K += A[i];
            res.addFirst(K%10);
            K /= 10;
            i--;
        }

        while(K >=0){
            res.addFirst(K%10);
            K /= 10;
        }

        while (i >= 0){
            res.addFirst(A[i--]);
        }

        return res;
    }

    //approach to convert K to int[] or string, takes 2/3ms
    public List<Integer> addToArrayForm(int[] A, int K) {
        //   int[] A = new int[]{1,2,0,0}; int K = 34;
        List<Integer> result = new ArrayList<>();
        String secondNumber = String.valueOf(K);
        int carry = 0;
        int i = A.length - 1, j = secondNumber.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int sum = 0;
            sum = A[i] + Integer.parseInt(String.valueOf(secondNumber.charAt(j))) + carry;
            carry = sum / 10;
            result.add(sum % 10);
        }

        for (; i >= 0; i--) {
            int sum = carry + A[i];
            carry = sum / 10;
            result.add(sum % 10);
        }

        for (; j >= 0; j--) {
            int sum = carry + Integer.parseInt(String.valueOf(secondNumber.charAt(j)));
            carry = sum / 10;
            result.add(sum % 10);
        }

        if (carry > 0)
            result.add(carry);
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        // int[] A = new int[]{1, 2, 0, 0}; int K = 34;
        //Output: [1,2,3,4] a = 1200 k = 34, result = a+ k = 1200 + 34 = 1234;
        //
        //int[] A = new int[]{2,1,5}; int K = 806;
//        Output: [1,0,2,1]

        int[] A = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}; int K = 1;
        //Output: [1,0,0,0,0,0,0,0,0,0,0]

       // int[] A = new int[]{6};        int K = 809;
        //Output: [2,3]

        SumArrayForm sumArrayForm = new SumArrayForm();
        List<Integer> result = sumArrayForm.addToArrayForm(A, K);
        sumArrayForm.printList(result);

        result = sumArrayForm.addToArrayForm(A, K);
        sumArrayForm.printList(result);
    }

    public static void printList(List<Integer> result){
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();
    }
}
