/**
 * Implementation of a Red Black Tree for CS361
 * @param <K>
 * @param <V>
 * @author Henry Baker
 * @version 2023.30.10
 */
public class RedBlackTree<K extends Comparable<K>,V>{
    Node root;

    private class Node {
        K key;
        V value;
        int size;
        boolean isRed;

        Node leftChild;
        Node rightChild;
        //Node parent;

        public Node(K key, V value, boolean color, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.size = 1;
            isRed = color;
            leftChild = left;
            rightChild = right;
            //parent = p;
        }
    }

    public RedBlackTree() {
        root = null;
    }

    public void put(K key, V value) {

    }

    public V get(K key) {
        return null;
    }

    public V delete(K key) {
        return null;
    }

    public boolean containsKey(K key) {
        return false;
    }

    public boolean containsValue(V value) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public K reverseLookup(V value) {
        return null;
    }

    public K findFirstKey() {
        return null;
    }

    public K findLastKey() {
        return null;
    }

    public K getRootKey() {
        return null;
    }

    public K findPredecessor(K key) {
        return null;
    }

    public K findSuccessor() {
        return null;
    }

    public int findRank(K key) {
        return 0;
    }

    public K select(int rank) {
        return null;
    }

    public int countRedNodes() {
        return 0;
    }

    public int calcHeight() {
        return 0;
    }

    public int calcBlackHeight() {
        return 0;
    }

    public double calcAverageDepth() {
        return 0.0;
    }

    // PRIVATE METHODS
    // ---------------

    /**
     * Find and Add Method to help the put() method in RedBlackTree (recursive).
     *
     * @param root The node to begin the find and add from
     * @param key The key to be put in the tree
     * @param value The value associated with key
     * @return The node added to the list or the node whose value was updated
     */
    private Node findAndAdd(Node root, K key, V value) {
        // WRITE TESTS
        if(root == null) {
            root = new Node(key, value, true, null, null);
            root.size = 1;
            return root;
        }
        if(key.compareTo(root.key) == 0) {
            root.value = value;
            return root;
        }
        if(key.compareTo(root.key) < 0) {
            root.leftChild = findAndAdd(root.leftChild, key, value);
            root.size = root.leftChild.size + root.rightChild.size + 1;
        } else {
            root.rightChild = findAndAdd(root.rightChild, key, value);
            root.size = root.leftChild.size + root.rightChild.size + 1;
        }
        // Fix Broken Tree Structure
        // 1. If left child is black and right child is red, ROTATE LEFT
        if(!root.leftChild.isRed && root.rightChild.isRed) {
            rotateLeft(root);
        }
        // 2. If left child and left-left grandchild are red, ROTATE RIGHT
        if(root.leftChild.isRed && root.leftChild.leftChild.isRed) {
            rotateRight(root);
        }
        // 3. If both children are red, COLOR FLIP
        if(root.leftChild.isRed && root.rightChild.isRed) {
            colorFlip(root);
        }
        return root;
    }

    /**
     * Left Rotation helper method
     * @param current The current "root node" to perform the rotation from.
     */
    private void rotateRight(Node current) {
        K key = current.key;
        V val = current.value;
        Node temp = current.rightChild;

        // SWAP left to current and current to left
        current.key = current.leftChild.key;
        current.value = current.leftChild.value;

        current.leftChild.key = key;
        current.leftChild.value = val;


        // Current right child becomes left
        current.rightChild = current.leftChild;

        // right - left grandchild becomes left child
        current.leftChild = current.rightChild.leftChild;

        // moves my right-right grandchild to be right-left grandchild
        current.rightChild.leftChild = current.rightChild.rightChild;

        // right-right grandchild is now original right child of current
        current.rightChild.rightChild = temp;
    }

    /**
     * Right Rotation helper method...
     * @param current The current "root node" to perform the rotation from.
     */
    private void rotateLeft(Node current) {
        K key = current.key;
        V val = current.value;
        Node temp = current.leftChild;

        // SWAP right to current and current to right
        current.key = current.rightChild.key;
        current.value = current.rightChild.value;

        current.rightChild.key = key;
        current.rightChild.value = val;


        // Current left child becomes right
        current.leftChild = current.rightChild;

        // left - right grandchild becomes right child
        current.rightChild = current.leftChild.rightChild;

        // moves my left-left grandchild to be left-right grandchild
        current.leftChild.rightChild = current.leftChild.leftChild;

        // left-left grandchild is now original right child of current
        current.leftChild.leftChild = temp;
    }

    /**
     * Color Flip helper method
     * @param current The "root node" to do the Color Flip on.
     */
    private void colorFlip(Node current) {
        current.leftChild.isRed = !current.leftChild.isRed;
        current.rightChild.isRed = !current.rightChild.isRed;
        current.isRed = !current.isRed;

        assert((current.leftChild.isRed != current.isRed) && (current.rightChild.isRed != current.isRed));
    }
}
