public class RedBlackTree<K,V> {
    private class Node {
        K key;
        V value;
        int size;
        boolean isRed;

        Node leftChild;
        Node rightChild;
        Node parent;
    }

    public RedBlackTree() {

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
}
