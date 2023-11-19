package eugene.boldyrev._12_splay_and_randomized_trees;

import eugene.boldyrev._10_linear_sorts.ArrayUtils;

import java.util.Random;

public class RandomizedTree extends SplayTree{

    protected int size;

    protected Random random;

    public RandomizedTree() {
        super();
        this.random = new Random();
    }

    public void add(int key) {
        addedNode = null;
        root = add(null, root, key);
        size++;

        int p = random.nextInt(size + 1);
        if (p == size) {
//            System.out.println("Splay " + key);
            splay(addedNode);
        }
    }

    public boolean delete(int key) {
        boolean deleted = super.delete(key);
        if (deleted) {
            size--;
        }
        return deleted;
    }

    public boolean find(int key) {
        found = null;
        find(root, key);
        return found != null;
    }

    public static void main(String[] args) {
        // Manual testing
        int[] ints = {30, 10, 4, 12, 14, 16, 15, 40, 50, 38, 36, 37};
        ArrayUtils.print(ints);

        RandomizedTree st = new RandomizedTree();
        st.setData(ints);
        System.out.println("end");

        boolean b = st.delete(15);
        System.out.println("Deleted = " + b);

        //------------------------------------

    }
}
