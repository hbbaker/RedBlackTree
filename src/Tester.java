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

        assert(tree.getRootKey() == 'R');

    }
}
