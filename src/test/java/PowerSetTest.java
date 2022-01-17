import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PowerSetTest {
    @Test
    public void testAdd() {
        PowerSet set = new PowerSet();
        set.put("test1");
        assertEquals(1, set.size());
        set.put("test1");
        assertEquals(1, set.size());
        set.put("test2");
        assertEquals(2, set.size());
    }

    @Test
    public void testRemove() {
        PowerSet set = new PowerSet();
        set.put("test1");
        set.put("test2");
        assertFalse(set.remove("test3"));
        assertEquals(2, set.size());
        assertTrue(set.remove("test1"));
        assertEquals(1, set.size());
        assertFalse(set.get("test1"));
    }

    @Test
    public void testSubset() {
        PowerSet set = new PowerSet();
        set.put("test1");
        set.put("test2");
        set.put("test3");
        set.put("test4");
        set.put("test5");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        set2.put("test5");
        PowerSet set3 = new PowerSet();
        set3.put("test55");
        set3.put("yrrg5");
        PowerSet set4 = new PowerSet();
        set4.put("test1");
        set4.put("test55");
        PowerSet set5 = new PowerSet();

        assertTrue(set.isSubset(set2));
        assertFalse(set.isSubset(set3));
        assertFalse(set.isSubset(set4));
        assertTrue(set.isSubset(set5));
        assertTrue(set2.isSubset(set5));
        assertTrue(set3.isSubset(set5));
        assertTrue(set4.isSubset(set5));
    }

    @Test
    public void testDifference() {
        PowerSet set = new PowerSet();
        set.put("test1");
        set.put("test2");
        set.put("test3");
        set.put("test4");
        set.put("test5");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        set2.put("test5");
        PowerSet set3 = new PowerSet();
        set3.put("test55");
        set3.put("yrrg5");
        PowerSet set4 = new PowerSet();
        set4.put("test1");
        set4.put("test55");
        PowerSet set5 = new PowerSet();

        PowerSet difference1 = set.difference(set2);
        assertEquals(3, difference1.size());
        assertTrue(difference1.get("test1"));
        assertTrue(difference1.get("test3"));
        assertTrue(difference1.get("test4"));

        PowerSet difference2 = set.difference(set3);
        assertEquals(5, difference2.size());
        assertTrue(difference2.get("test1"));
        assertTrue(difference2.get("test2"));
        assertTrue(difference2.get("test3"));
        assertTrue(difference2.get("test5"));
        assertTrue(difference2.get("test4"));

        PowerSet difference3 = set.difference(set4);
        assertEquals(4, difference3.size());
        assertTrue(difference3.get("test2"));
        assertTrue(difference3.get("test3"));
        assertTrue(difference3.get("test5"));
        assertTrue(difference3.get("test4"));

        PowerSet difference4 = set.difference(set5);
        assertEquals(5, difference4.size());
        assertTrue(difference4.get("test1"));
        assertTrue(difference4.get("test2"));
        assertTrue(difference4.get("test3"));
        assertTrue(difference4.get("test5"));
        assertTrue(difference4.get("test4"));
    }

    @Test
    public void testUnion() {
        PowerSet set = new PowerSet();
        set.put("test1");
        set.put("test2");
        set.put("test3");
        set.put("test4");
        set.put("test5");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        set2.put("test5");
        PowerSet set3 = new PowerSet();
        set3.put("test55");
        set3.put("yrrg5");
        PowerSet set4 = new PowerSet();
        set4.put("test1");
        set4.put("test55");
        PowerSet set5 = new PowerSet();

        PowerSet union1 = set.union(set2);
        assertEquals(5, union1.size());
        assertTrue(union1.get("test1"));
        assertTrue(union1.get("test2"));
        assertTrue(union1.get("test3"));
        assertTrue(union1.get("test4"));
        assertTrue(union1.get("test5"));

        PowerSet union2 = set.union(set3);
        assertEquals(7, union2.size());
        assertTrue(union2.get("test1"));
        assertTrue(union2.get("test2"));
        assertTrue(union2.get("test3"));
        assertTrue(union2.get("test5"));
        assertTrue(union2.get("test55"));
        assertTrue(union2.get("test4"));
        assertTrue(union2.get("yrrg5"));

        PowerSet union3 = set.union(set4);
        assertEquals(6, union3.size());
        assertTrue(union3.get("test55"));
        assertTrue(union3.get("test1"));
        assertTrue(union3.get("test2"));
        assertTrue(union3.get("test3"));
        assertTrue(union3.get("test5"));
        assertTrue(union3.get("test4"));

        PowerSet union4 = set.union(set5);
        assertEquals(5, union4.size());
        assertTrue(union4.get("test1"));
        assertTrue(union4.get("test2"));
        assertTrue(union4.get("test3"));
        assertTrue(union4.get("test5"));
        assertTrue(union4.get("test4"));
    }

    @Test
    public void testIntersection() {
        PowerSet set = new PowerSet();
        set.put("test1");
        set.put("test2");
        set.put("test3");
        set.put("test4");
        set.put("test5");
        PowerSet set2 = new PowerSet();
        set2.put("test2");
        set2.put("test5");
        PowerSet set3 = new PowerSet();
        set3.put("test55");
        set3.put("yrrg5");
        PowerSet set4 = new PowerSet();
        set4.put("test1");
        set4.put("test55");
        PowerSet set5 = new PowerSet();

        PowerSet intersection1 = set.intersection(set2);
        assertEquals(2, intersection1.size());
        assertTrue(intersection1.get("test2"));
        assertTrue(intersection1.get("test5"));

        PowerSet intersection2 = set.intersection(set3);
        assertEquals(0, intersection2.size());

        PowerSet intersection3 = set.intersection(set4);
        assertEquals(1, intersection3.size());
        assertTrue(intersection3.get("test1"));

        PowerSet intersection4 = set.intersection(set5);
        assertEquals(0, intersection4.size());

    }
}
