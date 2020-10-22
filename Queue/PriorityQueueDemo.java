package Queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.add(10);
        queue.add(15);
        queue.add(12);

        System.out.println(queue.peek());
        System.out.println(queue.poll());

    }
}
