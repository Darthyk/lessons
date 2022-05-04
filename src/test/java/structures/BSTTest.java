package structures;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class BSTTest {
    @Test
    public void testBstWideSearch() {
        BST<Integer> tree = fillTree();
        ArrayList<BSTNode1> bstNode1s = tree.WideAllNodes();
    }

    private BST<Integer> fillTree() {
        BST<Integer> tree;

        BSTNode1<Integer> root = new BSTNode1<>(9, 9, null);
        tree = new BST<>(root);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(17, 17);
        tree.AddKeyValue(22, 22);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(20, 20);
        return tree;
    }
}
