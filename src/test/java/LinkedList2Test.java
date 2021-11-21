import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedList2Test {
    @Test
    public void testFindExistingValue() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        Node node = linkedList2.find(4);
        assertNotNull(node);
    }

    @Test
    public void testFindNotExistingValue() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        assertNull(linkedList2.find(7));
    }

    @Test
    public void testFindInEmptyList() {
        LinkedList2 linkedList2 = new LinkedList2();
        assertNull(linkedList2.find(7));
    }

    @Test
    public void testFindAllExistingValues() {
        LinkedList2 linkedList2 = getListWith3EqualValues();
        ArrayList<Node> nodes = linkedList2.findAll(4);
        assertEquals(3, nodes.size());
    }

    @Test
    public void testFind1ValueByFindAll() {
        LinkedList2 linkedList2 = getListWith3EqualValues();
        ArrayList<Node> nodes = linkedList2.findAll(1);
        assertEquals(1, nodes.size());
    }

    @Test
    public void testFindNotExistingNodeByFindAll() {
        LinkedList2 linkedList2 = getListWith3EqualValues();
        ArrayList<Node> nodes = linkedList2.findAll(1000);
        assertTrue(nodes.isEmpty());
    }

    @Test
    public void testFindFindAllInEmptyList() {
        LinkedList2 linkedList2 = new LinkedList2();
        ArrayList<Node> nodes = linkedList2.findAll(1000);
        assertTrue(nodes.isEmpty());
    }

    @Test
    public void testRemoveFromHead() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        assertTrue(linkedList2.remove(1));
        assertEquals(5, linkedList2.count());
        assertEquals(linkedList2.find(2), linkedList2.head);
        assertNull(linkedList2.head.prev);
        assertNotNull(linkedList2.head.next);
        assertEquals(linkedList2.head.next, linkedList2.find(3));
        assertTrue(linkedList2.remove(5));
        assertEquals(4, linkedList2.count());
    }

    @Test
    public void testRemoveFromTail() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        assertTrue(linkedList2.remove(6));
        assertEquals(5, linkedList2.count());
        assertEquals(linkedList2.find(5), linkedList2.tail);
        assertNull(linkedList2.tail.next);
        assertNotNull(linkedList2.tail.prev);
        assertEquals(linkedList2.find(4), linkedList2.tail.prev);
        assertTrue(linkedList2.remove(3));
        assertEquals(4, linkedList2.count());
    }

    @Test
    public void testRemoveFromMiddle() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        Node tail = linkedList2.tail;
        Node head = linkedList2.head;
        Node node = linkedList2.find(3);
        assertTrue(linkedList2.remove(3));
        assertEquals(5, linkedList2.count());
        assertEquals(node.prev, linkedList2.find(2));
        assertEquals(node.next, linkedList2.find(2).next);
        assertEquals(node.next, linkedList2.find(4));
        assertEquals(node.prev, linkedList2.find(4).prev);
        assertEquals(tail, linkedList2.tail);
        assertEquals(head, linkedList2.head);
    }

    @Test
    public void testRemoveFromEmptyList() {
        LinkedList2 linkedList2 = new LinkedList2();
        assertFalse(linkedList2.remove(9));
        assertNull(linkedList2.head);
        assertNull(linkedList2.tail);
    }

    @Test
    public void testRemoveNotExistingFromList() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        assertFalse(linkedList2.remove(9));
        assertEquals(6, linkedList2.count());
    }

    @Test
    public void testRemoveOneFromOne() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(1));
        assertEquals(1, linkedList2.count());
        assertEquals(linkedList2.tail, linkedList2.find(1));
        assertEquals(linkedList2.head, linkedList2.find(1));
        assertNull(linkedList2.find(1).next);
        assertNull(linkedList2.find(1).prev);
        assertTrue(linkedList2.remove(1));
        assertNull(linkedList2.tail);
        assertNull(linkedList2.head);
    }

    @Test
    public void testRemoveAllFromHead() {
        LinkedList2 linkedList2 = getListWith3EqualValuesInHead();
        linkedList2.removeAll(1);
        assertEquals(3, linkedList2.count());
        assertEquals(linkedList2.find(4), linkedList2.head);
        assertNull(linkedList2.head.prev);
        assertEquals(linkedList2.find(6), linkedList2.tail);
        assertNull(linkedList2.tail.next);
        assertEquals(linkedList2.find(5), linkedList2.tail.prev);
    }

    @Test
    public void testRemoveAllFromTail() {
        LinkedList2 linkedList2 = getListWith3EqualValuesInTail();
        linkedList2.removeAll(6);
        assertEquals(3, linkedList2.count());
        assertEquals(linkedList2.find(1), linkedList2.head);
        assertNull(linkedList2.head.prev);
        assertEquals(linkedList2.find(3), linkedList2.tail);
        assertNull(linkedList2.tail.next);
        assertEquals(linkedList2.find(2), linkedList2.tail.prev);
    }

    @Test
    public void testRemoveAllFromList() {
        LinkedList2 linkedList2 = getListWith3EqualValues();
        linkedList2.removeAll(4);
        assertEquals(3, linkedList2.count());
        assertEquals(linkedList2.find(1), linkedList2.head);
        assertNull(linkedList2.head.prev);
        assertEquals(linkedList2.find(5), linkedList2.tail);
        assertNull(linkedList2.tail.next);
        assertEquals(linkedList2.find(2), linkedList2.tail.prev);
    }

    @Test
    public void testRemoveAllFromEmptyList() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.removeAll(4);
        assertEquals(0, linkedList2.count());
    }

    @Test
    public void testRemoveAllNotExisting() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        linkedList2.removeAll(45);
        assertEquals(6, linkedList2.count());
        assertEquals(linkedList2.head, linkedList2.find(1));
        assertNull(linkedList2.find(1).prev);
        assertEquals(linkedList2.tail, linkedList2.find(6));
        assertNull(linkedList2.find(6).next);
    }

    @Test
    public void testRemoveAllFromAll() {
        LinkedList2 linkedList2 = getListWithAllEqualValues();
        linkedList2.removeAll(1);
        assertEquals(0, linkedList2.count());
        assertNull(linkedList2.head);
        assertNull(linkedList2.tail);
    }

    @Test
    public void testClear() {
        LinkedList2 linkedList2 = getListWith3EqualValues();
        linkedList2.clear();
        assertEquals(0, linkedList2.count());
        assertNull(linkedList2.tail);
        assertNull(linkedList2.head);
    }

    @Test
    public void testInsertAfterHead() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        Node node = linkedList2.find(1);
        Node nodeToInsert = new Node(8);
        linkedList2.insertAfter(node, nodeToInsert);
        assertEquals(7, linkedList2.count());
        assertEquals(linkedList2.find(1), linkedList2.head);
        assertNull(linkedList2.find(1).prev);
        assertEquals(linkedList2.find(6), linkedList2.tail);
        assertNull(linkedList2.find(6).next);
        assertEquals(8, linkedList2.find(1).next.value);
        assertEquals(2, linkedList2.find(8).next.value);
    }

    @Test
    public void testInsertAfterTail() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        Node node = linkedList2.find(6);
        Node nodeToInsert = new Node(8);
        linkedList2.insertAfter(node, nodeToInsert);
        assertEquals(7, linkedList2.count());
        assertEquals(linkedList2.find(8), linkedList2.tail);
        assertNull(linkedList2.tail.next);
        assertEquals(linkedList2.find(6), linkedList2.tail.prev);
    }

    @Test
    public void testInsertInEmptyList() {
        LinkedList2 linkedList2 = new LinkedList2();
        Node node = new Node(4);
        linkedList2.insertAfter(node, new Node(5));
        assertEquals(1, linkedList2.count());
        assertEquals(linkedList2.head, linkedList2.find(5));
        assertEquals(linkedList2.tail, linkedList2.find(5));
        assertNull(linkedList2.find(5).prev);
        assertNull(linkedList2.find(5).next);
    }

    @Test
    public void testInsertInHead() {
        LinkedList2 linkedList2 = getListWithDifferentValues();
        Node node = new Node(44);
        linkedList2.insertAfter(null, node);
        assertEquals(7, linkedList2.count());
        assertEquals(linkedList2.head, linkedList2.find(44));
        assertEquals(linkedList2.tail, linkedList2.find(6));
        assertNull(linkedList2.find(44).prev);
        assertEquals(linkedList2.find(1), linkedList2.find(44).next);
    }

    private LinkedList2 getListWithDifferentValues() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(2));
        linkedList2.addInTail(new Node(3));
        linkedList2.addInTail(new Node(4));
        linkedList2.addInTail(new Node(5));
        linkedList2.addInTail(new Node(6));
        return linkedList2;
    }

    private LinkedList2 getListWith3EqualValues() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(2));
        linkedList2.addInTail(new Node(4));
        linkedList2.addInTail(new Node(4));
        linkedList2.addInTail(new Node(5));
        linkedList2.addInTail(new Node(4));
        return linkedList2;
    }

    private LinkedList2 getListWith3EqualValuesInHead() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(4));
        linkedList2.addInTail(new Node(5));
        linkedList2.addInTail(new Node(6));
        return linkedList2;
    }

    private LinkedList2 getListWith3EqualValuesInTail() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(2));
        linkedList2.addInTail(new Node(3));
        linkedList2.addInTail(new Node(6));
        linkedList2.addInTail(new Node(6));
        linkedList2.addInTail(new Node(6));
        return linkedList2;
    }

    private LinkedList2 getListWithAllEqualValues() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        linkedList2.addInTail(new Node(1));
        return linkedList2;
    }
}
