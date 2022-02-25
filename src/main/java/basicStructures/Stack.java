package basicStructures;

import java.util.*;

public class Stack<T>
{
    private ArrayList<T> arrayList;
    public Stack()
    {
        arrayList = new ArrayList<>();
        // инициализация внутреннего хранилища стека
    }

    public int size()
    {
        // размер текущего стека
        return arrayList.size();
    }

    public T pop()
    {
        // ваш код
        if (!arrayList.isEmpty()) {
            T value = arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
            return value;
        } else {
            return null;  // если стек пустой
        }
    }

    public void push(T val)
    {
        // ваш код
        arrayList.add(val);
    }

    public T peek()
    {
        // ваш код
        if (!arrayList.isEmpty()) {
            return arrayList.get(arrayList.size() - 1);
        } else {
            return null; // если стек пустой
        }
    }
}