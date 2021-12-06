import java.util.*;

public class Queue<T>
{
    private List<T> queue;
    public Queue()
    {
        // инициализация внутреннего хранилища очереди
        queue = new ArrayList<>();
    }

    public void enqueue(T item)
    {
        // вставка в хвост
        queue.add(item);
    }

    public T dequeue()
    {
        // выдача из головы
        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            return null; // null если очередь пустая
        }
    }

    public int size()
    {
        return queue.size(); // размер очереди
    }

}