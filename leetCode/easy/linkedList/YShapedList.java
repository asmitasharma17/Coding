package leetCode.easy.linkedList;

public class YShapedList {

    /**
     * Get count of the nodes in the first list, let count be c1.
     * Get count of the nodes in the second list, let count be c2.
     * Get the difference of counts d = abs(c1 – c2)
     * Now traverse the bigger list from the first node till d nodes so that from here
     * onwards both the lists have equal no of nodes.
     * Then we can traverse both the lists in parallel till we come across a common
     */
    // 1ms
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = count(headA);
        int countB = count(headB);
        int diff = Math.abs(countA - countB);

        if (countA > countB) {
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else if (countB > countA) {
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int count(ListNode node) {
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        return count;
    }

    //hashing
    // 7ms
    /**
     * public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
     * Set<ListNode> set = new HashSet<>();
     * while (headA != null) {
     * set.add(headA);
     * headA = headA.next;
     * }
     * <p>
     * while (headB != null) {
     * if (set.contains(headB))
     * return headB;
     * headB = headB.next;
     * }
     * <p>
     * return null;
     * }
     **/

    public static void main(String[] args) {
        // list 1
        // 1 2 3 4 5 6 7
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        n1.next.next.next = new ListNode(4);
        n1.next.next.next.next = new ListNode(5);
        n1.next.next.next.next.next = new ListNode(6);
        n1.next.next.next.next.next.next = new ListNode(7);
        // list 2
        //10 9 8 4 5 6 7
        ListNode n2 = new ListNode(10);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(8);
        n2.next.next.next = n1.next.next.next;
        Print(n1);
        Print(n2);

        YShapedList il = new YShapedList();
       // Print(il.getIntersectionNode(n1, n2));

        //4,1,8,4,5
        ListNode n3 = new ListNode(4);
        n3.next = new ListNode(1);
        n3.next.next = new ListNode(8);
        n3.next.next.next = new ListNode(4);
        n3.next.next.next.next = new ListNode(5);
        // list 2
        //5,6,1,8,4,5
        ListNode n4 = new ListNode(5);
        n4.next = new ListNode(6);
        n4.next.next = n3.next;
        Print(n3);
        Print(n4);

        Print(il.getIntersectionNode(n3, n4));
    }

    private static void Print(ListNode n1) {
        ListNode curr = n1;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /***
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     *
     * For example, the following two linked lists:
     *
     *
     * begin to intersect at node c1.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * Output: Reference of the node with value = 8
     * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
     *
     *
     * Example 2:
     *
     *
     * Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
     * Output: Reference of the node with value = 2
     * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
     *
     *
     * Example 3:
     *
     *
     * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
     * Output: null
     * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
     * Explanation: The two lists do not intersect, so return null.
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     * https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
     */
}
