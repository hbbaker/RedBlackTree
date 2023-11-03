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

        System.out.println("Deleting R");
        int testInt = tree.delete('E');
        System.out.println(testInt);
        testInt = tree.delete('R'); // Delete something that isn't in the tree
        System.out.println(testInt);

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
        System.out.println(intScoreTree.getRootKey());
        assert(intScoreTree.getRootKey() == 5 || intScoreTree.getRootKey() == 20);

    }
}
