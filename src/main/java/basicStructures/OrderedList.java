package basicStructures;

import java.util.*;

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
        if (v1.getClass() == Integer.class) {
            if ((int) v1 < (int) v2) {
                return -1;
            }
            if ((int) v1 == (int) v2) {
                return 0;
            } else {
                return 1;
            }
        } else {
           return  (v1.toString().trim()).compareTo(v2.toString().trim());
        }
    }

    public void add(T value)
    {
        if (head == null) {
            addInTail(new Node(value));
            return;
        }
        if (_ascending == true) {
            addInAsc(new Node<>(value));
        } else {
            addInDesc(new Node<>(value));
        }
        // автоматическая вставка value 
        // в нужную позицию
    }

    void addInAsc(Node<T> item) {
        Node<T> node = head;
        while (node != null && compare(item.value, node.value) >= 0) {
            node = node.next;
        }
        if (node == null) {
            addInTail(item);
            return;
        }

        item.prev = node.prev;
        if (head != node) {
            node.prev.next = item;
        } else {
            head = item;
        }
        node.prev = item;
        item.next = node;

    }

    void addInDesc(Node<T> item) {
        Node<T> node = head;

        while (node != null && compare(item.value, node.value) <= 0) {
            node = node.next;
        }

        if (node == null) {
            addInTail(item);
            return;
        }
        item.prev = node.prev;

        if (head != node) {
            node.prev.next = item;
        } else {
            head = item;
        }
        node.prev = item;
        item.next = node;
    }

    public void addInTail(Node<T> node) {
        if (head == null) {
            head = node;
            node.prev = null;
            node.next = null;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
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
        if (node != null) {
            if (node.prev == null && node.next == null) {
                head = null;
                tail = null;
                return;
            }
            if (node.prev == null) {
                head = node.next;
                node.next.prev = null;
                return;
            }
            if (node.next == null) {
                node.prev.next = null;
                tail = node.prev;
                node.prev = null;
                return;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
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

    public ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
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