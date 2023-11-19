package eugene.boldyrev._12_splay_and_randomized_trees;

import eugene.boldyrev._10_linear_sorts.ArrayUtils;

import java.util.Random;

import static eugene.boldyrev._10_linear_sorts.ArrayUtils.measure;

public class TreeTestScenario {

    private final SplayTree tree;


    public TreeTestScenario(SplayTree tree){
        this.tree = tree;
    }

    public void run(int[] ints){
        tree.setData(ints);

        Random random = new Random();
        measure("Search for 100 random elements", () -> {
            for (int i=0; i < 100; i++){
                int p = random.nextInt(1001);
                tree.find(p);
            }
        });

        measure("Search for 1000 elements from 1 to 10", () -> {
            for (int i=0; i < 1000; i++){
                for (int j=0; j < 10; j++) {
                    tree.find(j);
                }
            }
        });

        measure("Delete 100 random elements", () -> {
            for (int i=0; i < 100; i++){
                int p = random.nextInt(1001);
                tree.delete(p);
            }
        });

    }

    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateRandom(1000, 1001);

        System.out.println("Splay tree");
        new TreeTestScenario(new SplayTree()).run(ints);
        System.out.println("--------------------");

        System.out.println("Randomized tree");
        new TreeTestScenario(new RandomizedTree()).run(ints);
    }
}
