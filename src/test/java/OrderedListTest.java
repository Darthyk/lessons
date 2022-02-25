import basicStructures.Node;
import basicStructures.OrderedList;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OrderedListTest {
    private final static boolean ASCENDING = true;
    private final static boolean DESCENDING = false;

    @Test
    public void testAddToEmpty() {
        OrderedList<Integer> orderedList = new OrderedList<>(ASCENDING);
        orderedList.add(1);
        assertEquals(orderedList.head.value, 1);
        assertEquals(orderedList.tail.value, 1);
        assertEquals(orderedList.count(), 1);
    }

    @Test void testAddToHeadAsc() {
        OrderedList<Integer> orderedList = getAscList();
        orderedList.add(1);
        assertEquals(orderedList.head.value, 1);
        assertEquals(5, orderedList.count());
        assertEquals(orderedList.head.next.value, 2);
        assertEquals(orderedList.tail.value, 8);
    }

    @Test void testAddToMiddleAsc() {
        OrderedList<Integer> orderedList = getAscList();
        orderedList.add(5);
        assertEquals(orderedList.head.value, 2);
        assertEquals(5, orderedList.count());
        Node<Integer> insertedNode = orderedList.find(5);
        assertEquals(orderedList.find(4).next, insertedNode);
        assertEquals(orderedList.find(6).prev, insertedNode);
        assertEquals(orderedList.tail.value, 8);
    }

    @Test void testAddToTailAsc() {
        OrderedList<Integer> orderedList = getAscList();
        orderedList.add(9);
        assertEquals(orderedList.head.value, 2);
        assertEquals(5, orderedList.count());
        assertEquals(orderedList.tail.prev.value, 8);
        assertEquals(orderedList.tail.value, 9);
    }

    @Test void testAddToHeadDesc() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.add(9);
        assertEquals(orderedList.head.value, 9);
        assertEquals(5, orderedList.count());
        assertEquals(orderedList.head.next.value, 8);
        assertEquals(orderedList.tail.value, 2);
    }

    @Test void testAddToMiddleDesc() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.add(5);
        assertEquals(orderedList.head.value, 8);
        assertEquals(5, orderedList.count());
        Node<Integer> insertedNode = orderedList.find(5);
        assertEquals(orderedList.find(6).next, insertedNode);
        assertEquals(orderedList.find(4).prev, insertedNode);
        assertEquals(orderedList.tail.value, 2);
    }

    @Test void testAddToTailDesc() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.add(1);
        assertEquals(orderedList.head.value, 8);
        assertEquals(5, orderedList.count());
        assertEquals(orderedList.tail.prev.value, 2);
        assertEquals(orderedList.tail.value, 1);
    }

    @Test void testDelete1From1() {
        OrderedList<Integer> orderedList = new OrderedList<>(ASCENDING);
        orderedList.add(1);
        assertEquals(orderedList.count(), 1);
        assertEquals(orderedList.head.value, 1);
        assertEquals(orderedList.tail.value, 1);
        orderedList.delete(1);
        assertNull(orderedList.tail);
        assertNull(orderedList.head);
    }

    @Test void testDeleteHeadAsc() {
        OrderedList<Integer> orderedList = getAscList();
        orderedList.delete(2);
        assertEquals(orderedList.head.value, 4);
        assertNull(orderedList.head.prev);
        assertEquals(3, orderedList.count());
        assertEquals(orderedList.head.next.value, 6);
        assertEquals(orderedList.tail.value, 8);
    }

    @Test void testDeleteMiddleAsc() {
        OrderedList<Integer> orderedList = getAscList();
        orderedList.delete(6);
        assertEquals(orderedList.head.value, 2);
        assertEquals(3, orderedList.count());
        assertEquals(orderedList.tail.prev.value, 4);
        assertEquals(orderedList.tail.value, 8);
    }

    @Test void testDeleteTailAsc() {
        OrderedList<Integer> orderedList = getAscList();
        orderedList.delete(8);
        assertEquals(orderedList.head.value, 2);
        assertEquals(3, orderedList.count());
        assertEquals(orderedList.tail.prev.value, 4);
        assertEquals(orderedList.tail.value, 6);
    }

    @Test void testDeleteHeadDesc() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.delete(8);
        assertEquals(orderedList.head.value, 6);
        assertEquals(3, orderedList.count());
        assertEquals(orderedList.head.next.value, 4);
        assertEquals(orderedList.tail.value, 2);
    }

    @Test void testDeleteMiddleDesc() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.delete(4);
        assertEquals(orderedList.head.value, 8);
        assertEquals(3, orderedList.count());
        assertEquals(orderedList.tail.prev.value, 6);
        assertEquals(orderedList.tail.value, 2);
    }

    @Test void testDeleteTailDesc() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.delete(2);
        assertEquals(orderedList.head.value, 8);
        assertEquals(3, orderedList.count());
        assertEquals(orderedList.tail.prev.value, 6);
        assertEquals(orderedList.tail.value, 4);
    }

    @Test void testGetAllAsc() {
        OrderedList<Integer> orderedList = getAscList();
        ArrayList<Node<Integer>> all = orderedList.getAll();
        assertEquals(all.get(0).value, 2);
        assertEquals(all.get(1).value, 4);
        assertEquals(all.get(2).value, 6);
        assertEquals(all.get(3).value, 8);
    }

    @Test void testGetAllDesc() {
        OrderedList<Integer> orderedList = getDescList();
        ArrayList<Node<Integer>> all = orderedList.getAll();
        assertEquals(all.get(0).value, 8);
        assertEquals(all.get(1).value, 6);
        assertEquals(all.get(2).value, 4);
        assertEquals(all.get(3).value, 2);
    }

    @Test void testClear() {
        OrderedList<Integer> orderedList = getDescList();
        orderedList.clear(DESCENDING);
        assertEquals(orderedList.count(), 0);
        assertNull(orderedList.head);
        assertNull(orderedList.tail);
    }

    private OrderedList<Integer> getAscList() {
        OrderedList<Integer> list = new OrderedList<>(ASCENDING);
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        return list;
    }

    private OrderedList<Integer> getDescList() {
        OrderedList<Integer> list = new OrderedList<>(DESCENDING);
        list.add(8);
        list.add(6);
        list.add(4);
        list.add(2);
        return list;
    }
}
