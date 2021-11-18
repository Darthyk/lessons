/*
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    @Test
    public void addOneToEmptyList() {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node node = new LinkedList.Node(4);
        linkedList.addInTail(node);
        assertEquals(node, linkedList.head);
        assertEquals(node, linkedList.tail);
    }

    @Test
    public void addTwoToEmptyList() {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node node = new LinkedList.Node(4);
        LinkedList.Node node2 = new LinkedList.Node(7);
        linkedList.addInTail(node);
        linkedList.addInTail(node2);
        assertEquals(node, linkedList.head);
        assertEquals(node2, linkedList.tail);
        assertNull(linkedList.tail.next);
    }

    @Test
    public void testClear() {
       LinkedList linkedList = getWithDifferentValues();
       linkedList.clear();
        assertNull(linkedList.tail);
        assertNull(linkedList.head);
    }

    @Test
    public void testRemove() {
        LinkedList linkedList = getWithEqualValues();
        assertTrue(linkedList.remove(3));
        assertEquals(5, linkedList.count());
        assertEquals(linkedList.find(2).next.value, linkedList.find(4).value);
        assertTrue(linkedList.remove(4));
        assertEquals(4, linkedList.count());
    }

    @Test
    public void testRemoveOneFromHead() {
        LinkedList linkedList = getWithEqualValues();
        LinkedList.Node tail = linkedList.tail;
        assertTrue(linkedList.remove(4));
        assertEquals(5, linkedList.count());
        assertEquals(linkedList.find(2), linkedList.head);
        assertTrue(linkedList.remove(4));
        assertEquals(4, linkedList.count());
        assertEquals(linkedList.find(2), linkedList.head);
        assertEquals(tail, linkedList.tail);
    }

    @Test
    public void testRemoveOneFromTail() {
        LinkedList linkedList = getWithDifferentValues();
        LinkedList.Node tail = linkedList.tail;
        LinkedList.Node head = linkedList.head;
        assertTrue(linkedList.remove(6));
        assertEquals(5, linkedList.count());
        assertEquals(head, linkedList.head);
        assertEquals(linkedList.find(5), linkedList.tail);
    }

    @Test
    public void testRemoveFromNull() {
        LinkedList linkedList = new LinkedList();
        assertFalse(linkedList.remove(3));
        assertEquals(0, linkedList.count());
    }

    @Test
    public void testRemoveNull() {
        LinkedList linkedList = getWithDifferentValues();
        assertFalse(linkedList.remove(0));
        assertEquals(6, linkedList.count());
    }

    @Test
    public void testRemoveOneFromOne() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(2));
        assertTrue(linkedList.remove(2));
        assertEquals(0, linkedList.count());
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    public void testRemoveAll() {
        LinkedList linkedList = getWithEqualValues();
        linkedList.removeAll(4);
        assertEquals(3, linkedList.count());
    }

    @Test
    public void testRemoveAllFromAll() {
        LinkedList linkedList = getWithAllEqualValues();
        linkedList.removeAll(4);
        assertEquals(0, linkedList.count());
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    public void testRemoveAllFromTail() {
        LinkedList linkedList = getWithEqualValuesInTail();
        LinkedList.Node head = linkedList.head;
        linkedList.removeAll(4);
        assertEquals(3, linkedList.count());
        assertEquals(head, linkedList.head);
        assertEquals(linkedList.find(3), linkedList.tail);
        assertNull(linkedList.tail.next);
    }

    @Test
    public void testRemoveOneByAllFromTail() {
        LinkedList linkedList = getWithDifferentValues();
        linkedList.removeAll(6);
        assertEquals(5, linkedList.count());
        assertNull(linkedList.tail.next);
        assertEquals(linkedList.find(5), linkedList.tail);
    }

    @Test
    public void testRemoveAllFromHead() {
        LinkedList linkedList = getWithEqualValuesInHead();
        linkedList.removeAll(3);
        assertEquals(3, linkedList.count());
        assertNull(linkedList.tail.next);
    }

    @Test
    public void testRemoveAllFromMiddle() {
        LinkedList linkedList = getWithEqualValuesInMiddle();
        LinkedList.Node head = linkedList.head;
        linkedList.removeAll(5);
        assertEquals(4, linkedList.count());
        assertNull(linkedList.tail.next);
        assertEquals(head, linkedList.head);
    }

    @Test
    public void testFind() {
        LinkedList linkedList = getWithDifferentValues();
        LinkedList.Node node = linkedList.find(2);
        assertNotNull(node);
    }

    @Test
    public void testInsertAfter() {
        LinkedList linkedList = getWithDifferentValues();
        LinkedList.Node nodeAfter = linkedList.find(1);
        LinkedList.Node nodeToInsert = new LinkedList.Node(8);
        linkedList.insertAfter(nodeAfter, nodeToInsert);
        assertEquals(nodeAfter.value, linkedList.find(1).value);
        assertEquals(nodeAfter.next.value, linkedList.find(8).value);
        linkedList.insertAfter(null, new LinkedList.Node(9));
        assertEquals(linkedList.head.value, linkedList.find(9).value);
    }

    @Test
    public void testInsertAfterInEmptyList() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node nodeAfter = new LinkedList.Node(19);
        LinkedList.Node nodeToInsert = new LinkedList.Node(1);

        linkedList.insertAfter(nodeAfter, nodeToInsert);
        assertEquals(nodeToInsert, linkedList.find(1));
    }

    @Test
    public void testInsertAfterInHead() {
        LinkedList linkedList = getWithDifferentValues();

        LinkedList.Node head = linkedList.head;
        LinkedList.Node next = linkedList.head.next;
        LinkedList.Node tail = linkedList.tail;
        LinkedList.Node nodeAfter = linkedList.find(1);
        LinkedList.Node nodeToInsert = new LinkedList.Node(9);

       linkedList.insertAfter(nodeAfter, nodeToInsert);

       assertEquals(7, linkedList.count());
       assertEquals(head, linkedList.head);
       assertEquals(next, nodeToInsert.next);
       assertEquals(tail, linkedList.tail);
    }

    @Test
    public void testInsertAfterInTail() {
        LinkedList linkedList = getWithDifferentValues();

        LinkedList.Node head = linkedList.head;
        LinkedList.Node nodeAfter = linkedList.find(6);
        LinkedList.Node nodeToInsert = new LinkedList.Node(9);

        linkedList.insertAfter(nodeAfter, nodeToInsert);

        assertEquals(7, linkedList.count());
        assertEquals(head, linkedList.head);
        assertEquals(nodeToInsert, linkedList.tail);

    }

    @Test
    public void testFindAll() {
        LinkedList linkedList = getWithEqualValues();
        ArrayList<LinkedList.Node> nodes = linkedList.findAll(4);
        assertEquals(3, nodes.size());
    }

    private LinkedList getWithDifferentValues() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(1));
        linkedList.addInTail(new LinkedList.Node(2));
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(5));
        linkedList.addInTail(new LinkedList.Node(6));
        return linkedList;
    }

    private LinkedList getWithEqualValues() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(2));
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(6));
        return linkedList;
    }

    private LinkedList getWithAllEqualValues() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        return linkedList;
    }

    private LinkedList getWithEqualValuesInTail() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(1));
        linkedList.addInTail(new LinkedList.Node(2));
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        return linkedList;
    }

    private LinkedList getWithEqualValuesInHead() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        return linkedList;
    }

    private LinkedList getWithEqualValuesInMiddle() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(3));
        linkedList.addInTail(new LinkedList.Node(5));
        linkedList.addInTail(new LinkedList.Node(5));
        linkedList.addInTail(new LinkedList.Node(4));
        linkedList.addInTail(new LinkedList.Node(4));
        return linkedList;
    }
}*/
