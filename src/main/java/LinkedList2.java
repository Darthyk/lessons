import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        // здесь будет ваш код поиска
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов по заданному значению
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        // здесь будет ваш код удаления одного узла по заданному значению
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                removeNode(node);
                return true;
            }
            node = node.next;
        }
        return false; // если узел был удалён
    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                removeNode(node);
            }
            node = node.next;
        }
    }

    private void removeNode(Node node) {
        if (node.equals(this.head) && node.equals(this.tail)) {
            this.head = null;
            this.tail = null;
        } else if (node.equals(this.head)) {
            this.head = node.next;
            this.head.prev = null;
        } else if (node.equals(this.tail)) {
            this.tail = node.prev;
            this.tail.next = null;
        } else {
            Node previous = node.prev;
            Node next = node.next;
            previous.next = next;
            next.prev = previous;
        }
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла
        if (this.head == null) {
            addInTail(_nodeToInsert);
        } else if (_nodeAfter == null || find(_nodeAfter.value) == null) {
            _nodeToInsert.next = this.head;
            _nodeToInsert.prev = null;
            this.head = _nodeToInsert;
        } else {
            Node node = find(_nodeAfter.value);
            if (this.tail.equals(node)) {
                addInTail(_nodeToInsert);
            } else {
                Node nodeNext = node.next;
                node.next = _nodeToInsert;
                _nodeToInsert.next = nodeNext;
            }
        }

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}