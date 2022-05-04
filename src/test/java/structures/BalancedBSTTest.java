package structures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BalancedBSTTest {

    @Test
    public void test1() {
        int[] incoming = new int[] {5, 1, 3, 2, 4, 7, 6};

        BalancedBST bst = new BalancedBST();
        bst.GenerateTree(incoming);
        Assertions.assertTrue(bst.IsBalanced(bst.Root));
    }
}
