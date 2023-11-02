public class Tester {

    public static void main(String[] args) {
        RedBlackTree<Character, Integer> tree = new RedBlackTree<Character,Integer>();

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

        RedBlackTree<Character, Integer> tree2 = new RedBlackTree<Character,Integer>();
        tree2.put('E', 10);
        tree2.put('C', 12);
        tree2.put('D', 14);

        assert(tree2.getRootKey() == 'D');

        int testInt = tree2.delete('D');
        System.out.println(testInt);
    }
}
