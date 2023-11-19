package eugene.boldyrev._11_binary_search_tree;

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