/**
 * Implementation of a Red Black Tree for CS361
 * @param <K>
 * @param <V>
 * @author Henry Baker
 * @version 2023.30.10
 */
public class RedBlackTree<K extends Comparable<K>,V>{
    Node root;


    /**
     * Private Node Class that drives RedBlackTree structure
     */
    private class Node {
        K key;
        V value;
        int size;
        boolean isRed;

        Node leftChild;
        Node rightChild;

        /**
         * Constructor for internal Node class for RedBlackTree
         * @param key Key stored in the node
         * @param value Value stored in the node
         * @param left Reference to the Left Child of Node
         * @param right Reference to the Right Child of Node
         */
        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.size = 1;
            isRed = true;
            leftChild = left;
            rightChild = right;
        }

        /**
         * Updates the size of the node based on its children
         */
        private void updateSize() {
            int size = 1;
            if(leftChild != null) {
                size += leftChild.size;
            }
            if(rightChild != null) {
                size += rightChild.size;
            }
            this.size = size;
        }

        /**
         * Helper to delete a node and promote its left child
         */
        private Node delete(Object[] val) {
            assert(this.isRed && this.rightChild == null);
            val[0] = this.value;
            System.out.println("Deleting: " + this.key);
            return this.leftChild;
        }

        /**
         * Helper to Fix tree structure
         */
        private void fixNodes() {

            // 3. If both children are red, COLOR FLIP (helps with delete)
            if(leftChild != null && rightChild != null) {
                if(leftChild.isRed && rightChild.isRed) {
                    colorFlip(this);
                    System.out.println("Color Flipped " + key);
                }
            }

            // 1. If current is black and right child is red, ROTATE LEFT
            //TODO - CHECK THIS!!!!!!!
            if(leftChild == null && rightChild != null && rightChild.isRed) {
                System.out.println("Rotated " + key + " Left");
                rotateLeft(this);
            }

            if (rightChild != null && leftChild != null && !leftChild.isRed && rightChild.isRed) {
                System.out.println("Rotated " + key + " Left");
                rotateLeft(this);
            }

            // 2. If left child and left-left grandchild are red, ROTATE RIGHT
            if(leftChild != null && leftChild.leftChild != null) {
                if(leftChild.isRed && leftChild.leftChild.isRed) {
                    System.out.println("Rotated " + key +" Right");
                    rotateRight(this);
                }
            }

            // 3. If both children are red, COLOR FLIP
            if(leftChild != null && rightChild != null) {
                if(leftChild.isRed && rightChild.isRed) {
                    colorFlip(this);
                    System.out.println("Color Flipped " + key);
                }
            }

            updateSize();
        }

    }

    /**
     * Constructor for RedBlackTree
     */
    public RedBlackTree() {
        root = null;
    }

    /**
     * Puts a value for a given key into the RedBlackTree
     * @param key The key to be put
     * @param value The value to be put at key
     */
    public void put(K key, V value) {
        root = findAndAdd(root, key, value);
        root.isRed = false;
    }

    /**
     *
     * @param key
     * @return
     */
    public V get(K key) {

        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    public V delete(K key) {
        Object[] val = new Object[1];

        if(root == null) {
            return null;
        }
        root.isRed = true;
        root = findAndDelete(root, null, key, val);
        if(root != null) {
            root.isRed = false;
        }
        if(val[0] != null) {
            return (V) val[0];
        } else {
            return null;
        }
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean containsKey(K key) {
        return false;
    }

    /**
     *
     * @param value
     * @return
     */
    public boolean containsValue(V value) {
        return false;
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     *
     * @return
     */
    public int size() {
        return this.root.size;
    }

    /**
     *
     * @param value
     * @return
     */
    public K reverseLookup(V value) {
        return null;
    }

    /**
     *
     * @return
     */
    public K findFirstKey() {
        return null;
    }

    /**
     *
     * @return
     */
    public K findLastKey() {
        return null;
    }

    /**
     *
     * @return
     */
    public K getRootKey() {
        return this.root.key;
    }

    /**
     *
     * @param key
     * @return
     */
    public K findPredecessor(K key) {
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    public K findSuccessor(K key) {
        return null;
    }

    /**
     *
     * @param key
     * @return
     */
    public int findRank(K key) {
        return 0;
    }

    /**
     *
     * @param rank
     * @return
     */
    public K select(int rank) {
        return null;
    }

    /**
     *
     * @return
     */
    public int countRedNodes() {
        return 0;
    }

    /**
     *
     * @return
     */
    public int calcHeight() {
        return 0;
    }

    /**
     * Calculates the Black Height of RedBlackTree
     * @return int Black Height
     */
    public int calcBlackHeight() {
        Node n = root;
        if(n == null) {
            return 0;
        }
        int count = 1;
        while(n.rightChild != null) {
            count++;
            n = n.rightChild;
        }
        return count;
    }

    /**
     * Calculates the Average Depth of RedBlackTree
     * @return Average Depth
     */
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
            root = new Node(key, value,null, null);
            return root;
        }
        if(key.compareTo(root.key) == 0) {
            root.value = value;
            return root;
        }
        if(key.compareTo(root.key) < 0) {
            root.leftChild = findAndAdd(root.leftChild, key, value);
            root.fixNodes();
        } else {
            root.rightChild = findAndAdd(root.rightChild, key, value);
            root.fixNodes();
        }
        return root;
    }

    /**
     * Helper method for delete() (recursive)
     * @param root Root node
     * @param found Stored node of key if found
     * @param key Key to be deleted
     * @param val Array to hold value of returned deletion
     * @return Root node
     */
    private Node findAndDelete(Node root, Node found, K key, Object[] val) {

        if(root == null) {
            return null;
        }
        assert(root.isRed);

        int compare = key.compareTo(root.key); //TODO - CHECK THIS: root.key.compareTo(key);

        if(compare == 0) {
            // Case 0: No children (leaf case) & Case 1
            if(root.rightChild == null){
                return root.delete(val);
            }else {
                //Case 2:
                compare = Math.random() >= 0.5? 1: -1; //Thanks, Adam!
                found = root;
            }

        }
        if(compare > 0) { // need to go right
            System.out.println("went right--------");
            if(root.leftChild != null && root.rightChild != null) {
                if(!root.leftChild.isRed && !root.rightChild.isRed) {
                    System.out.println("Color flipped going down");
                    colorFlip(root);
                }
                if(root.leftChild.isRed && !root.rightChild.isRed) {
                    System.out.println("Rotated Right going down!");
                    rotateRight(root);
                }
            }
            root.rightChild = findAndDelete(root.rightChild, found, key, val);
            if(found != null && root.rightChild == null && val[0] == null) {
                K rootKey = found.key;
                V rootVal = found.value;
                found.key = root.key;
                found.value = root.value;
                root.key = rootKey;
                root.value = rootVal;
                return root.delete(val);
            }
        } else { // need to go left
            System.out.println("went left");
            if(root.leftChild != null && root.rightChild != null) {
                if(!root.leftChild.isRed && !root.rightChild.isRed) {
                    colorFlip(root);
                }
            }
            // TODO - Make sure you don't have to do any checks for R left and B right at this case.
            root.leftChild = findAndDelete(root.leftChild, found, key, val);
            if(found != null && root.rightChild == null && val[0] == null) {
                K rootKey = found.key;
                V rootVal = found.value;
                found.key = root.key;
                found.value = root.value;
                root.key = rootKey;
                root.value = rootVal;
                return root.delete(val);
            }
        }
        root.fixNodes();
        return root;
    }

    /**
     * Right Rotation helper method
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


        // Current right child becomes left && remove left
        current.rightChild = current.leftChild;
        current.leftChild = null;

        // right - left grandchild becomes left child
        if(current.rightChild.leftChild != null) {
            current.leftChild = current.rightChild.leftChild;
            current.rightChild.leftChild = null;
        }

        // moves my right-right grandchild to be right-left grandchild
        if(current.rightChild.rightChild != null) {
            current.rightChild.leftChild = current.rightChild.rightChild;
            current.rightChild.rightChild = null;
        }


        // right-right grandchild is now original right child of current
        if(temp != null) {
            current.rightChild.rightChild = temp;
        }

        current.rightChild.updateSize();
    }

    /**
     * Left Rotation helper method...
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


        // Current left child becomes right & remove right
        current.leftChild = current.rightChild;
        current.rightChild = null;

        // left - right grandchild becomes right child
        if(current.leftChild.rightChild != null) {
            current.rightChild = current.leftChild.rightChild;
            current.leftChild.rightChild = null;
        }

        // moves my left-left grandchild to be left-right grandchild
        if(current.leftChild.leftChild != null) {
            current.leftChild.rightChild = current.leftChild.leftChild;
            current.leftChild.leftChild = null;
        }


        // left-left grandchild is now original right child of current
        if(temp != null) {
            current.leftChild.leftChild = temp;
        }

        current.leftChild.updateSize();
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
