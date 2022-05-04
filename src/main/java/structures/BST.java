package structures;

import java.util.*;


class BSTNode1<T>
{
    public int NodeKey; // ключ узла
    public T NodeValue; // значение в узле
    public BSTNode1<T> Parent; // родитель или null для корня
    public BSTNode1<T> LeftChild; // левый потомок
    public BSTNode1<T> RightChild; // правый потомок

    public BSTNode1(int key, T val, BSTNode1<T> parent)
    {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

// промежуточный результат поиска
class BSTFind<T>
{
    // null если в дереве вообще нету узлов
    public BSTNode1<T> Node;

    // true если узел найден
    public boolean NodeHasKey;

    // true, если родительскому узлу надо добавить новый левым
    public boolean ToLeft;

    public BSTFind() { Node = null; }
}

class BST<T>
{
    BSTNode1<T> Root; // корень дерева, или null

    private int nodeCount;

    public BST(BSTNode1<T> node)
    {
        Root = node;
        nodeCount = node == null ? 0 : 1;
    }

    public BSTFind<T> FindNodeByKey(int key)
    {
        // ищем в дереве узел и сопутствующую информацию по ключу
        BSTFind<T> bstFind = new BSTFind<>();
        if (Root != null) {
            bstFind.Node = findNode(Root, key);
            bstFind.NodeHasKey = bstFind.Node.NodeKey == key;
            bstFind.ToLeft = key < bstFind.Node.NodeKey;
        }
        return bstFind;
    }

    public boolean AddKeyValue(int key, T val)
    {
        // добавляем ключ-значение в дерево
        BSTFind<T> bstFind = FindNodeByKey(key);
        if (bstFind.NodeHasKey) {
            return false; // если ключ уже есть
        }
        BSTNode1<T> bstNode1 = new BSTNode1<>(key, val, bstFind.Node);
        if (bstFind.Node == null) {
            Root = bstNode1;
        } else {
            bstFind.Node.LeftChild = bstFind.ToLeft ? bstNode1 : bstFind.Node.LeftChild;
            bstFind.Node.RightChild = !bstFind.ToLeft ? bstNode1 : bstFind.Node.RightChild;
        }
        nodeCount++;
        return true;
    }

    public BSTNode1<T> FinMinMax(BSTNode1<T> FromNode, boolean FindMax)
    {
        // ищем максимальный/минимальный ключ в поддереве
        if (FromNode == null) {
            return null;
        }
        if (FindMax) {
            return findMaxNode(FromNode);
        }
        return findMinNode(FromNode);
    }

    public boolean DeleteNodeByKey(int key)
    {
        // удаляем узел по ключу
        BSTFind<T> bstFind = FindNodeByKey(key);
        if (!bstFind.NodeHasKey) {
            return false; // если узел не найден
        }
        Root = remove(Root, key);
        nodeCount--;
        return true;
    }

    public int Count()
    {
        return nodeCount; // количество узлов в дереве
    }

    private BSTNode1<T> findNode(BSTNode1<T> root, int key) {
        if (root == null || root.NodeKey == key) {
            return root;
        }
        BSTNode1<T> node;
        if (key < root.NodeKey) {
            node = findNode(root.LeftChild, key);
        } else {
            node = findNode(root.RightChild, key);
        }
        return node == null ? root : node;
    }

    private BSTNode1<T> findMinNode(BSTNode1<T> root) {
        if (root.LeftChild == null) {
            return root;
        }
        return findMinNode(root.LeftChild);
    }

    private BSTNode1<T> findMaxNode(BSTNode1<T> root) {
        if (root.RightChild == null) {
            return root;
        }
        return findMaxNode(root.RightChild);
    }

    private BSTNode1<T> remove(BSTNode1<T> root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.NodeKey) {
            root.LeftChild = remove(root.LeftChild, key);
        } else if (key > root.NodeKey) {
            root.RightChild = remove(root.RightChild, key);
        } else {
            if (root.LeftChild == null) {
                return root.RightChild;
            } else if (root.RightChild == null) {
                return root.LeftChild;
            } else {
                BSTNode1<T> node = findMinNode(root.RightChild);
                root.NodeKey = node.NodeKey;
                root.NodeValue = node.NodeValue;
                root.RightChild = remove(root.RightChild, node.NodeKey);
            }
        }
        return root;
    }

    ArrayList<BSTNode1> WideAllNodes() {
        ArrayList<BSTNode1> nodes = new ArrayList<>();
        if (Root != null) {
            runThroughLevelNodes(Root, nodes);
        }
        return nodes;
    }

    void runThroughLevelNodes(BSTNode1 node, ArrayList<BSTNode1> nodes) {
        ArrayDeque<BSTNode1> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            BSTNode1 bstNode1 = queue.poll();
            nodes.add(bstNode1);
            if (bstNode1.LeftChild != null) {
                queue.offer(bstNode1.LeftChild);
            }
            if (bstNode1.RightChild != null) {
                queue.offer(bstNode1.RightChild);
            }
        }
    }

    public ArrayList<BSTNode1> DeepAllNodes(int order) {
        ArrayList<BSTNode1> nodes = new ArrayList<>();
        if (Root != null) {
            switch (order) {
                case 0:
                    inOrderDeepSearch(Root, nodes);
                    break;
                case 1:
                    postOrderDeepSearch(Root, nodes);
                    break;
                case 2:
                    preOrderDeepSearch(Root, nodes);
                    break;
                default:
                    return nodes;
            }
        }
        return nodes;
    }

    private void inOrderDeepSearch(BSTNode1<T> root, ArrayList<BSTNode1> nodes) {
        if (root == null) {
            return;
        }
        inOrderDeepSearch(root.LeftChild, nodes);
        nodes.add(root);
        inOrderDeepSearch(root.RightChild, nodes);
    }

    private void postOrderDeepSearch(BSTNode1<T> root, ArrayList<BSTNode1> nodes) {
        if (root == null) {
            return;
        }
        postOrderDeepSearch(root.LeftChild, nodes);
        postOrderDeepSearch(root.RightChild, nodes);
        nodes.add(root);
    }

    private void preOrderDeepSearch(BSTNode1<T> root, ArrayList<BSTNode1> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        preOrderDeepSearch(root.LeftChild, nodes);
        preOrderDeepSearch(root.RightChild, nodes);
    }
}