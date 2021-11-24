import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynArrayTest {
    @Test
    public void testChangeCapacity() {
        DynArray array = new DynArray(Integer.class);
        assertEquals(16, array.capacity);
        assertEquals(0, array.count);
        array.makeArray(25);
        assertEquals(25, array.capacity);
        array.makeArray(14);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testGetItem() {
        DynArray array = new DynArray(Integer.class);
        array.append(1);
        assertEquals(16, array.capacity);
        assertEquals(1, array.count);
        try {
            array.getItem(17);
        } catch (Exception e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
        Integer item = (Integer) array.getItem(0);
        assertEquals(1, item);
        try {
            array.getItem(1);
        } catch (Exception e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    public void testAppend() {
        DynArray array = getFullDynArray();
        assertEquals(16, array.count);
        assertEquals(16, array.capacity);
        array.append(17);
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
    }

    @Test
    public void testInsertInEmpty() {
        DynArray array = new DynArray(Integer.class);
        try {
            array.insert(1, 3);
        } catch (Exception e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
        array.insert(1, 0);
        assertEquals(1, array.getItem(0));
        assertEquals(1, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testInsert() {
        DynArray array = new DynArray(Integer.class);
        for (int i = 1; i<= 5; i++) {
            array.append(i);
        }

        array.insert(6, 3);
        assertEquals(6, array.getItem(3));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(4));
        assertEquals(6, array.count);
        assertEquals(16, array.capacity);
    }

    @Test
    public void testInsertInFullToEnd() {
        DynArray array = getFullDynArray();

        array.insert(17, array.count);
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
        assertEquals(17, array.getItem(16));
        assertEquals(16, array.getItem(15));
    }

    @Test
    public void testInsertInFullToMiddle() {
        DynArray array = getFullDynArray();

        array.insert(17, 3);
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
        assertEquals(17, array.getItem(3));
        assertEquals(3, array.getItem(2));
        assertEquals(4, array.getItem(4));
    }

    @Test
    public void testRemoveFromEmpty() {
        DynArray array = new DynArray(Integer.class);
        try {
            array.remove(0);
        } catch (Exception e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
        try {
            array.remove(2);
        } catch (Exception e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    public void testRemove() {
        DynArray array = getFullDynArray();
        try {
            array.remove(16);
        } catch (Exception e) {
            assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
        array.remove(15);
        assertEquals(15, array.count);
        assertEquals(15, array.getItem(array.count-1));
        assertEquals(16, array.capacity);
    }

    @Test
    public void testRemoveFromExtendedWithDecreasing() {
        DynArray array = getFullDynArray();
        array.append(17);
        assertEquals(17, array.count);
        assertEquals(32, array.capacity);
        array.remove(16);
        array.remove(15);
        assertEquals(15, array.count);
        assertEquals(15, array.getItem(array.count-1));
        assertEquals(21, array.capacity);
    }

    private DynArray getFullDynArray() {
        DynArray array = new DynArray(Integer.class);
        for (int i = 1; i <= 16; i++) {
            array.append(i);
        }

        return array;
    }
}
