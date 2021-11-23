import java.util.ArrayList;

/*
Существует интересный финт, обсуждаемый на курсе Стэнфордского университета CS106B -- фиктивный/пустой (dummy) узел.
 Пока нам при любых модификациях списка (добавление/удаление узла) приходится рассматривать три отдельные ситуации:
  работа с серединой списка, с его головой и с его хвостом. Фиктивный узел позволяет избавиться от этих краевых ситуаций,
   оставив только по одной универсальной операции на добавление и удаление. Идея в том, что мы добавляем в список два
    искусственных узла -- голову и хвост, которые пользователю класса не видны (они отличаются от видимых узлов,
     например, булевым флажком, а лучше всего это делать через наследование и перегрузку). Теперь, добавляя или удаляя
      узлы, мы всегда будем уверены, что у каждого из них имеется и предыдущий узел, и последующий, и от дополнительных
       проверок и модификаций полей head и tail можно избавиться.
В реализации для тестов на сервере такую схему применять не надо, сделайте отдельную реализацию, бонус до +500.
 */
public class LinkedList2Upgraded
{
    public Node1 head;
    public Node1 tail;
    private Node1Upgr realHead;
    private Node1Upgr realTail;

    public LinkedList2Upgraded()
    {
        head = null;
        tail = null;
        realHead = new Node1Upgr();
        realHead.next = head;
        realHead.prev = null;
        realTail = new Node1Upgr();
        realTail.next = null;
        realTail.prev = tail;
    }

    public void addInTail(Node1 _item)
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

    public Node1 find(int _value)
    {
        // здесь будет ваш код поиска
        Node1 node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node1> findAll(int _value)
    {
        ArrayList<Node1> nodes = new ArrayList<Node1>();
        // здесь будет ваш код поиска всех узлов по заданному значению
        Node1 node = this.head;
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
        Node1 node = this.head;
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
        Node1 node = this.head;
        while (node != null) {
            if (node.value == _value) {
                removeNode(node);
            }
            node = node.next;
        }
    }

    private void removeNode(Node1 node) {
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
            Node1 previous = node.prev;
            Node1 next = node.next;
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
        Node1 node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node1 _nodeAfter, Node1 _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла
        if (this.head == null) {
            addInTail(_nodeToInsert);
        } else if (_nodeAfter == null || find(_nodeAfter.value) == null) {
            _nodeToInsert.next = this.head;
            _nodeToInsert.prev = null;
            this.head = _nodeToInsert;
        } else {
            Node1 node = find(_nodeAfter.value);
            if (this.tail.equals(node)) {
                addInTail(_nodeToInsert);
            } else {
                Node1 nodeNext = node.next;
                node.next = _nodeToInsert;
                _nodeToInsert.next = nodeNext;
            }
        }

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
    }
}

class Node1
{
    public int value;
    public Node1 next;
    public Node1 prev;

    public Node1(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

class Node1Upgr extends Node1
{
    public int value;
    public Node1 next;
    public Node1 prev;
    public boolean isDummy;

    public Node1Upgr()
    {
        super(0);
        this.isDummy = true;
    }
}