import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Number && v2 instanceof Number) {
            return Integer.compare((int) v1, (int) v2);
        } else {
            String trimmed1 = ((String) v1).trim();
            String trimmed2 = ((String) v2).trim();
            return trimmed1.compareTo(trimmed2);
        }
        //return 0;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value)
    {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            if (checkForAddInHeadOrTail(node)) {
                return;
            }

            Node<T> currNode = head;
            while (currNode != null) {
                if (_ascending) {
                    if (compare(node.value, currNode.value) > 0 && compare(node.value, currNode.next.value) <= 0) {
                        node.next = currNode.next;
                        node.prev = currNode;
                        currNode.next.prev = node;
                        currNode.next = node;
                    }
                } else {
                    if (compare(node.value, currNode.value) < 0 && compare(node.value, currNode.next.value) >= 0) {
                        node.next = currNode.next;
                        node.prev = currNode;
                        currNode.next.prev = node;
                        currNode.next = node;
                    }
                }
                currNode = currNode.next;
            }
        }
        // автоматическая вставка value 
        // в нужную позицию
    }

    private boolean checkForAddInHeadOrTail(Node<T> node) {
        boolean result = false;
        if (_ascending && compare(node.value, head.value) < 0) {
            addInHead(node);
            result = true;
        } else if (_ascending && compare(node.value, tail.value) > 0) {
            addInTail(node);
            result = true;
        } else if (!_ascending && compare(node.value, head.value) > 0) {
            addInHead(node);
            result = true;
        } else if (!_ascending && compare(node.value, tail.value) < 0) {
            addInTail(node);
            result = true;
        }
        return result;
    }

    private void addInTail(Node<T> node) {
        node.prev = tail;
        node.prev.next = node;
        tail = node;
    }

    private void addInHead(Node<T> node) {
        head.prev = node;
        node.next = head;
        head = node;
    }

    public Node<T> find(T val)
    {
        Node<T> node = head;
        while (node != null) {
            if (compare(val, node.value) == 0) {
                return node;
            }
            node = node.next;
        }
        return null; // здесь будет ваш код
    }

    public void delete(T val)
    {
        Node<T> node = find(val);
        if (node.equals(head) && node.equals(tail)) {
            tail = null;
            head = null;
        } else if (node.equals(head)) {
            head = node.next;
            head.prev = null;
        } else if (node.equals(tail)) {
            tail = node.prev;
            tail.next = null;
        } else {
            Node<T> prev = node.prev;
            Node<T> next = node.next;
            prev.next = next;
            next.prev = prev;
        }
        // здесь будет ваш код
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        tail = null;
        head = null;
        // здесь будет ваш код
    }

    public int count()
    {
        int count = 0;
        Node<T> node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного 
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}