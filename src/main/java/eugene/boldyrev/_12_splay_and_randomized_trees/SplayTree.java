package eugene.boldyrev._12_splay_and_randomized_trees;

public class SplayTree {

    protected Node root;

    protected Node addedNode;

    protected Node found;

    public SplayTree(int[] A) {
        initBST(A);
    }

    public SplayTree() {
        root = null;
    }

    public void add(int key) {
        addedNode = null;
        root = add(null, root, key);
//        System.out.println("Added node: " + addedNode);
//        System.out.println("Parent of added node: " + (addedNode.P != null ? addedNode.P : "none"));
        splay(addedNode);
    }

    public boolean find(int key) {
        found = null;
        find(root, key);
        if (found != null) {
            splay(found);
        }
        return found != null;
    }

    public boolean delete(int key) {
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
        Node parentOfFound = found.P;
        if (parentOfFound != null) {
            if (found.key > parentOfFound.key)
                parentOfFound.R = node;
            else
                parentOfFound.L = node;
        }
    }

    protected void find(Node node, int key) {
        if (node == null) return;

        if (key < node.key) {
            find(node.L, key);
        } else if (key > node.key) {
            find(node.R, key);
        } else { // if (key == node.key)
            found = node;
        }
    }

    private void initBST(int[] A) {
        root = null;
        for (int i : A) {
            add(i);
        }
    }

    protected Node add(Node parent, Node node, int key) {
        if (node == null) {
            addedNode = new Node(parent, key);
            return addedNode;
        }
        if (key < node.key) {
            node.L = add(node, node.L, key);
        }
        if (key > node.key) {
            node.R = add(node, node.R, key);
        }
        if (key == node.key) {
            addedNode = node;
            return node;
        }
        return node;
    }

    void leftRotate(Node x) {
        Node y = x.R;
        if (y != null) {
            x.R = y.L;
            if (y.L != null) y.L.P = x;
            y.P = x.P;
        }

        if (x.P == null) root = y;
        else if (x == x.P.L) x.P.L = y;
        else x.P.R = y;

        if (y != null) y.L = x;
        x.P = y;
    }

    void rightRotate(Node x) {
        Node y = x.L;
        if (y != null) {
            x.L = y.R;
            if (y.R != null) y.R.P = x;
            y.P = x.P;
        }
        
        if (x.P == null) root = y; 
        else if (x == x.P.L) x.P.L = y;
        else x.P.R = y;
        
        if (y != null) y.R = x;
        x.P = y;
    }

    void splay(Node x){
        while (x.P != null) {
            if (x.P.P == null) {
                if (x.P.L == x) rightRotate(x.P);
                else leftRotate(x.P);
            } else if (x.P.L == x && x.P.P.L == x.P) {
                rightRotate(x.P.P);
                rightRotate(x.P);
            } else if (x.P.R == x && x.P.P.R == x.P) {
                leftRotate(x.P.P);
                leftRotate(x.P);
            } else if (x.P.L == x && x.P.P.R == x.P) {
                rightRotate(x.P);
                leftRotate(x.P);
            } else {
                leftRotate(x.P);
                rightRotate(x.P);
            }
        }
    }

    public void setData(int[] ints) {
        initBST(ints);
    }

    public static void main(String[] args) {
        // Manual testing
        int[] ints = {30, 10, 4, 12, 4, 14, 16, 15, 40, 50, 38, 36, 37};
        SplayTree st = new SplayTree(ints);

        boolean b = st.delete(15);
        System.out.println("Deleted = " + b);

        //------------------------------------


    }
}
