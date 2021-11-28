import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StackTest {
    @Test
    public void testGetSize() {
        Stack stack = new Stack();
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        assertNull(stack.peek());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        Integer peek = stack.peek();
        assertEquals(3, peek);
        assertEquals(3, stack.size());
    }

    @Test
    public void testPush() {
        Stack<String> stack = new Stack<>();
        stack.push("Test1");
        assertEquals("Test1", stack.peek());
        stack.push("Test2");
        assertEquals("Test2", stack.peek());
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.peek());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.size());
    }
}
