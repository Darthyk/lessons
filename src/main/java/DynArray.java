import java.lang.reflect.Array;
import java.util.Arrays;

public class DynArray<T>
{
    private int minCapacity = 16;
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(minCapacity);
    }

    public void makeArray(int new_capacity)
    {
        if (new_capacity <= minCapacity) {
            new_capacity = minCapacity;
        }
        T[] array = (T[]) Array.newInstance(this.clazz, new_capacity);

        if (this.array != null) {
            array = Arrays.copyOf(this.array, new_capacity);
        }
        this.array = array.clone();
        this.capacity = new_capacity;
        // ваш код
    }

    public T getItem(int index)
    {
        checkIndex(index);
        return this.array[index];

        // ваш код
    }

    public void append(T itm)
    {
        increaseCapacityIfNeeded();
        this.array[count] = itm;
        count++;
        // ваш код
    }

    public void insert(T itm, int index)
    {

        if (count == index) {
            append(itm);
        } else {
            checkIndex(index);
            increaseCapacityIfNeeded();
            for (int i = count; i >= index; i--) {
                this.array[i] = this.array[i-1];
            }
            this.array[index] = itm;
            count++;
        }
        // ваш код
    }

    public void remove(int index)
    {
        // ваш код
        checkIndex(index);
        if (index < count - 1) {
            for (int i = index; i < count; i++) {
                this.array[i] = this.array[i+1];
            }
            count--;
            decreaseCapacityIfNeeded();
        } else {
            this.array[count-1] = null;
            count--;
            decreaseCapacityIfNeeded();
        }
    }

    private void decreaseCapacityIfNeeded() {
        if (this.count < capacity/2) {
            int newCapacity = (int) (capacity/1.5);
            makeArray(newCapacity < minCapacity ? minCapacity : newCapacity);
        }
    }

    private void increaseCapacityIfNeeded() {
        if (count == capacity) {
            makeArray(this.capacity * 2);
        }
    }

    private void checkIndex(int index) {
        if (index > this.count - 1 || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
