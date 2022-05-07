package ap.extra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lei
 * @date 03/26/2022 7:03 PM
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedBlockingDeque<>();
        q.offer(1); q.offer(2); q.offer(3);

        q.add(4);
        for (int i : q) {
            System.out.println(i);
        }
    }
}
