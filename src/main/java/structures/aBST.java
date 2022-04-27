package structures;

import java.util.*;

class aBST
{
    public Integer Tree []; // массив ключей
    private int depth;

    public aBST(int depth)
    {
        // правильно рассчитайте размер массива для дерева глубины depth:
        this.depth = depth;
        int tree_size = (int)(Math.pow(2, depth + 1) - 1);
        Tree = new Integer[ tree_size ];
        for(int i=0; i<tree_size; i++) {
            Tree[i] = null;
        }
    }

    public Integer FindKeyIndex(int key)
    {
        // ищем в массиве индекс ключа
        int index = 0;
        int level = 0;
        while (level <= depth) {
            if (Tree[index] == null) {
                return -index;
            }
            if (Tree[index] == key) {
                return index;
            }
            if (Tree[index] < key) {
                index = 2 * index + 1;
            }
            if (Tree[index] > key) {
                index = 2 * index + 2;
            }
            level++;
        }
        return null; // не найден
    }

    public int AddKey(int key)
    {
        // добавляем ключ в массив
        Integer index = FindKeyIndex(key);
        if (index == null) {
            return -1;
        }
        index = Math.abs(index);
        Tree[index] = key;
        return index;
        // индекс добавленного/существующего ключа или -1 если не удалось
    }

}
