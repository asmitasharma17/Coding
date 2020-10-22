package leetCode.medium.arrays;

import java.util.*;

public class AddTwoNumbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static List addTwoNumbers(List l1, List l2) {
        // l1 = 342
        // l2 = 465

        List<Integer> result = new ArrayList<>();

        if (l1.size() < l2.size()) {

        } else {
            int carry = 0;
            for (int i = 0; i < l1.size(); i++) {
                int sum = (int) l1.get(i) + (int) l2.get(i);
                if (sum > 9) {
                    carry = 1;
                    result.add(0);
                    result.add(i + 1, carry);
                } else {
                    if (!result.isEmpty() && (int) result.get(i) > 0) {
                        sum += (int) result.get(i);
                        result.set(i, sum);
                    } else {
                        result.add(sum);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(2, 4, 3);
        List<Integer> l2 = Arrays.asList(5, 6, 4);
        List<Integer> result = List.of(7, 0, 8);
        //Explanation: 342 + 465 = 807.
        Collections.reverse(l1);
        Collections.reverse(l2);
        result = addTwoNumbers(l1, l2);

        for (int i : result)
            System.out.print(i + " ");
        System.out.println();

        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        ListNode resultListNode = addTwoNumbers(listNode1, listNode2);
        while (resultListNode != null) {
            System.out.print(resultListNode.val + " ");
            resultListNode = resultListNode.next;
        }
    }

    //https://leetcode.com/problems/add-two-numbers/
    /**
     * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
     *
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     *
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     *
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */
}
