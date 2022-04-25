package basicStructures;

import basicStructures.Queue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    @Test
    public void testSize() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(0, queue.size());
        queue.enqueue(1);
        assertEquals(1, queue.size());
        for (int i = 2; i < 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(9, queue.size());
        queue.dequeue();
        assertEquals(8, queue.size());
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
        }
        assertEquals(10, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(9, queue.dequeue());
        assertEquals(10, queue.dequeue());
        assertEquals(0, queue.size());
    }
}
