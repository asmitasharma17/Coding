package geeksforgeeks.linkedList;

public class PrintLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.head = new LinkedList.Node(1);
        LinkedList.Node second = new LinkedList.Node(2);
        LinkedList.Node third = new LinkedList.Node(3);
        list.head.next = second;
        second.next = third;

        // traversalList(list);

        LinkedList list1 = new LinkedList();

        list1.push(4);
        list1.push(3);
        list1.push(2);
        list1.push(1);
        printReverse(list1.head);
    }

    public static void traversalList(LinkedList list) {
        LinkedList.Node n = LinkedList.head;
        while (n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public static void printReverse(LinkedList.Node head) {
        if (head == null) return;

        // print list of head node
        printReverse(head.next);

        // After everything else is printed
        System.out.print(head.data + " ");
    }

}
