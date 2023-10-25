package eugene.boldyrev._11_binary_search_tree;

import eugene.boldyrev._10_linear_sorts.AbstractSort;
import eugene.boldyrev._10_linear_sorts.ArrayUtils;

import java.util.Random;

public class BinarySearchTree extends AbstractSort {

    Node root;

    private int i;

    private boolean inited;

    private Node found;
    private Node parentOfFound;

    public BinarySearchTree(int[] A) {
        root = null;
        setData(A);
    }

    public void add(int key) {
        root = add(root, key);
    }

    public boolean find(int key) {
        initBST();
        found = null;
        find(null, root, key);
        return found != null;
    }

    public boolean delete(int key){
        if (find(key)) {
            if (found.L == null && found.R == null) { // 0 child elements
                setValueInFoundParentLink(null);
            } else {
                if (found.L != null && found.R != null) { // 2 child elements
                    int max = found.L.key;
                    Node maxParent = found;
                    Node current = found.L;
                    Node next = current.R;
                    while (next != null) {
                        if (next.key > max) {
                            max = next.key;
                            maxParent = current;
                        }
                        current = next;
                        next = current.R;
                    }
//                    System.out.println("Max element less then " + key + " is " + max + " and it's parent is " + maxParent.key);

                    found.key = max;

                    if (maxParent == found) {
                        maxParent.L = maxParent.L.L;
                    } else if (maxParent.R.L != null) {
                        maxParent.R = maxParent.R.L;
                    } else {
                        maxParent.R = null;
                    }

                } else if (found.L != null) { // 1 child L element
                    setValueInFoundParentLink(found.L);
                } else { // 1 child R element
                    setValueInFoundParentLink(found.R);
                }
            }
            return true;
        }
        return false;
    }

    private void setValueInFoundParentLink(Node node) {
        if (parentOfFound != null) {
            if (found.key > parentOfFound.key)
                parentOfFound.R = node;
            else
                parentOfFound.L = node;
        }
    }

    private void find(Node parent, Node node, int key) {
        if (node == null) return;

        if (key < node.key) {
            find(node, node.L, key);
        } else if (key > node.key) {
            find(node, node.R, key);
        } else { // if (key == node.key)

//            System.out.println(key + " found. Parent key = " + (parent != null ? parent.key : "null" ));
            parentOfFound = parent;
            found = node;
        }
    }

    public int[] sort() {
        initBST();

        i = 0;
        sort(root);
        return A;
    }

    private void initBST() {
        if (!inited) {
            System.out.println("Initializing BST");
            for (int i : this.A) {
                add(i);
            }
        }
        inited = true;
    }

    private void sort(Node node){
        if (node == null) return;
        sort(node.L);
        A[i++] = node.key;
        sort(node.R);
    }

    private Node add(Node node, int key){
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.L = add(node.L, key);
        }
        if (key > node.key) {
            node.R = add(node.R, key);
        }
        return node;
    }

    class Node {
        int key;
        Node L, R;

        Node(int key) {
            this.key = key;
            L = R = null;
        }
    }

    public static void testingScenario(int N, int[] ints){
        BinarySearchTree bst = new BinarySearchTree(ints);
        long b = System.nanoTime();
        bst.initBST();
        long e = System.nanoTime();
        System.out.println("BST initialization took " + (e-b)/1_000_000 +" ms");

        b = System.nanoTime();
        Random random = new Random(123467);
        for (int i = 0; i < N/10; i++) {
            int n = random.nextInt(N);
            bst.find(n);
        }
        e = System.nanoTime();
        System.out.println("Finding "+N/10 +" numbers took " + (e-b)/1_000_000 +" ms");

        b = System.nanoTime();
        for (int i = 0; i < N/10; i++) {
            int n = random.nextInt(N);
            bst.delete(n);
        }
        e = System.nanoTime();
        System.out.println("Deleting "+N/10 +" numbers took " + (e-b)/1_000_000 +" ms");
    }

    public static void main(String[] args) {


        // Manual testing
//        int[] ints = {30, 10, 4, 12, 14, 16, 15, 40, 50, 38, 36, 37};
//
//        ArrayUtils.print(ints);
//
//        BinarySearchTree bst = new BinarySearchTree(ints);
//        boolean delete = bst.delete(10);
//        System.out.println("Deleted = " + delete);

        //------------------------------------

        int N = 30_000_000;
//        System.out.println("Size "+ N + " | random numbers");
        int[] ints = ArrayUtils.generateRandom(N, N);
//        testingScenario(N, ints);

        N = 9_000;
        System.out.println("Size "+ N + " | ascending order");
        ints = ArrayUtils.ascendingOrder(N);
        testingScenario(N, ints);


//        for (int i = 100; i < 1_000_000_000; i *= 10) {
//            int[] ints = ArrayUtils.generateRandom(i, i);
//
//            System.out.printf("Array size: %d \n", ints.length);
//
//            BinarySearchTree bst = new BinarySearchTree(ints);
//            System.out.print("Binary search tree sort: ");
//            measure(bst);
//            System.out.println();
//        }
    }

}
