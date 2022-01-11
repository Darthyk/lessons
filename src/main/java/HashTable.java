public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        // всегда возвращает корректный индекс слота
        return value.length() % size;
    }

    public int seekSlot(String value)
    {
        int hash = hashFun(value);
        for (int i = 0; i < size; i++) {
            if (slots[hash] == null) {
                return hash;
            } else {
                hash = (hash + step) % size;
            }
        }
        // находит индекс пустого слота для значения, или -1
        return -1;
    }

    public int put(String value)
    {
        int slot = seekSlot(value);
        if (slot == -1) {
            return -1;
        } else {
            slots[slot] = value;
            return slot;
        }
        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
    }

    public int find(String value)
    {
        int hash = hashFun(value);
        for (int i = 0; i < size; i++) {
            if (slots[hash] != null) {
                if (slots[hash].equals(value)) {
                    return hash;
                } else {
                    hash = (hash + step) % size;
                }
            }
        }

        // находит индекс слота со значением, или -1
        return -1;
    }
}