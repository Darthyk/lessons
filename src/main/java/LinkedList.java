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
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
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
        while(remove(_value));
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
        if (_nodeAfter == null) {
            if (this.tail != null) {
                Node nextNode = this.head;
                this.head = _nodeToInsert;
                this.head.next = nextNode;
            } else if (this.head != null) {
                this.tail = this.head;
                this.head = _nodeToInsert;
            } else {
                this.head = _nodeToInsert;
            }
        } else {
            Node node = this.head;
            while (node != null) {
                if (node == _nodeAfter) {
                    _nodeToInsert.next = node.next;
                    node.next = _nodeToInsert;
                }
                node = node.next;
            }
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}

