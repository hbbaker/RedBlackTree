public class Tester {

    public static void main(String[] args) {
        RedBlackTree<Character, Integer> tree = new RedBlackTree<>();

        // Test put structure against class notes example...
        tree.put('S', 2);
        tree.put('E', 9);
        tree.put('A', 19);
        tree.put('R', 12);
        tree.put('C', 4);
        tree.put('H', 16);
        System.out.println(tree.getRootKey());
        System.out.println(tree.size());
        System.out.println(tree.calcBlackHeight());

        assert(tree.getRootKey() == 'R');

        RedBlackTree<Character, Integer> tree2 = new RedBlackTree<>();
        tree2.put('E', 10);
        tree2.put('C', 12);
        tree2.put('D', 14);

        assert(tree2.getRootKey() == 'D');

        //System.out.println("Deleting R");
        //int testInt = tree.delete('E');
        //System.out.println(testInt);
        //testInt = tree.delete('R'); // Delete something that isn't in the tree
        //System.out.println(testInt);

        RedBlackTree<Integer, Character> intScoreTree = new RedBlackTree<>();

        // Insertion Tests
        intScoreTree.put(10, 'A'); // Insert root
        intScoreTree.put(5, 'B'); // Insert Red node to left (Base Insert)
        intScoreTree.put(5, 'F'); // Change value of key 5
        intScoreTree.put(20, 'C'); // Insert Red node to right (Color Flip)
        // Insert 2 red nodes to the left (Rotate Right)
        intScoreTree.put(3, 'D');
        intScoreTree.put(2, 'E');

        intScoreTree.put(30, 'E'); // Insert red to right (Left Rotation)
        //-----------------

        // Deletion Tests
        intScoreTree.delete(10);
        System.out.println("Root Key: " + intScoreTree.getRootKey());
        assert(intScoreTree.getRootKey() == 5 || intScoreTree.getRootKey() == 20);

        intScoreTree = new RedBlackTree<>();

        intScoreTree.put(-7, 'A');
        intScoreTree.put(-6, 'B');
        intScoreTree.put(-5, 'C');
        intScoreTree.put(-4, 'D');
        intScoreTree.put(-3, 'E');
        intScoreTree.put(-2, 'F');
        intScoreTree.put(-1, 'G');
        intScoreTree.put(0, 'H');
        intScoreTree.put(1, 'I');
        intScoreTree.put(2, 'J');
        intScoreTree.put(3, 'K');
        intScoreTree.put(4, 'L');
        intScoreTree.put(5, 'M');
        intScoreTree.put(6, 'N');
        intScoreTree.put(7, 'O');

        System.out.println("Tree Height: " + intScoreTree.calcHeight());
        System.out.println("Black Height: " + intScoreTree.calcBlackHeight());

        System.out.println("Getting Key 3: " + intScoreTree.get(3));

        System.out.println("Average Depth of Tree: " + intScoreTree.calcAverageDepth());


    }
}
