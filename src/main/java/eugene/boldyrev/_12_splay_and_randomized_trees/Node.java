package eugene.boldyrev._12_splay_and_randomized_trees;

public class Node {
    int key;
    Node L, R;

    Node P;  // parent

    Node(Node parent, int key) {
        this.key = key;
        P = parent;
        L = R = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", Parent.key=" + (P == null? "null" : P.key) +
                ", L=" + L +
                ", R=" + R +
                '}';
    }
}