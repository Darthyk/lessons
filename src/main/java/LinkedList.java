import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
            this.tail = item;
        } else {
            this.tail.next = item;
            this.tail = item;
        }
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        Node previousNode = this.head;
        while (node != null) {
            if (node.value == _value) {
                if (previousNode.equals(this.head)) {
                    this.head = node.next;
                } else if (node.equals(this.tail)) {
                    this.tail = previousNode;
                    this.tail.next = null;
                } else {
                    previousNode.next = node.next;
                }
                if (this.head == null) {
                    this.tail = null;
                }
                return true;
            }
            previousNode = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        Node previousNode = this.head;
        while (node != null) {
            if (node.value == _value) {
                if (node.equals(this.head) && node.equals(this.tail)) {
                    this.head = null;
                    this.tail = null;
                    continue;
                } else if (node.equals(this.head)) {
                    this.head = node.next;
                    node = this.head;
                    previousNode = this.head;
                    continue;
                } else if (node.equals(this.tail)) {
                    this.tail = previousNode;
                    this.tail.next = null;
                    node = null;
                    continue;
                }
                previousNode.next = node.next;
                node = previousNode.next;
                continue;
            }
            previousNode = node;
            node = node.next;
        }
    }

    public void clear()
    {
        Node node = this.head;
        while (node != null) {
            this.head = node.next;
            node = node.next;
        }
        this.tail = null;
    }

    public int count()
    {
        int size = 0;
        Node node = this.head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == null || find(_nodeAfter.value) == null) {
            if (this.head == null && this.tail == null) {
                addInTail(_nodeToInsert);
            } else if (this.head != null && this.tail != null) {
                Node temp = this.head;
                this.head = _nodeToInsert;
                this.head.next = temp;
            }
        } else {
            Node node = find(_nodeAfter.value);
            if (this.tail == node) {
                addInTail(_nodeToInsert);
            } else {
                Node nextAfter = node.next;
                node.next = _nodeToInsert;
                node.next.next = nextAfter;
            }
        }
    }

    public static LinkedList getLinkedListSum(LinkedList list1, LinkedList list2) {
        if (list1.count() == list2.count()) {
            LinkedList sum = new LinkedList();
            Node node = list1.head;
            Node node1 = list2.head;
            Node sumNode;
            while (node != null && node1 != null) {
                sumNode = new Node(node.value + node1.value);
                sum.addInTail(sumNode);

                node = node.next;
                node1 = node1.next;
            }
            return sum;
        } else {
            return null;
        }
    }

    static class Node
    {
        public int value;
        public Node next;
        public Node(int _value)
        {
            value = _value;
            next = null;
        }
    }
}

