package datastructure.tree;

public class RED_BLACK_TREE {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    static class Node {
        int key;
        boolean color;
        Node left, right, parent;

        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    private Node root;

    private void rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != null) y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    private void rotateRight(Node y) {
        Node x = y.left;
        y.left = x.right;

        if (x.right != null) x.right.parent = y;
        x.parent = y.parent;
        if (y.parent == null) root = x;
        else if (y == y.parent.right) y.parent.right = x;
        else y.parent.left = x;
        x.right = y;
        y.parent = x;
    }

    public void insert(int key) {
        Node z = new Node(key, RED);
        Node y = null;
        Node x = root;

        while (x != null) {
            y = x;
            if (z.key < x.key) x = x.left;
            else x = x.right;
        }

        z.parent = y;
        if (y == null) root = z;
        else if (z.key < y.key) y.left = z;
        else y.right = z;

        insertFix(z);
    }

    public void insertFix(Node z) {
        while (z.parent != null && z.parent.color == RED) {
            if (z.parent == z.parent.parent.left) {
                Node y = z.parent.parent.right;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rotateRight(z.parent.parent);
                }
            } else {
                Node y = z.parent.parent.left;
                if (y != null && y.color == RED) {
                    z.parent.color = BLACK;
                    y.color = BLACK;
                    z.parent.parent.color = RED;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rotateRight(z);
                    }

                    z.parent.color = BLACK;
                    z.parent.parent.color = RED;
                    rotateLeft(z.parent.parent);
                }
            }
        }
        root.color = BLACK;
    }

    private void transplant(Node u, Node v) {
        if (u.parent == null) root = v;
        else if (u == u.parent.left) u.parent.left = v;
        else u.parent.right = v;
        if (v != null) v.parent = u.parent;
    }

    private Node minimum(Node x) {
        while (x.left != null) x = x.left;
        return x;
    }

    public void delete(int key) {
        Node z = search(root, key);
        if (z == null) return;

        Node y = z;
        boolean yOriginalColor = y.color;
        Node x;

        if (z.left == null) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == null) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.color;
            x = y.right;
            if (y.parent == z) {
                if (x != null) x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }

            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }

        if (yOriginalColor == BLACK) {
            deleteFix(x, z.parent);
        }
    }

    public void deleteFix(Node x, Node parent) {
        while (x != root && (x == null || x.color == BLACK)) {
            if (x == parent.left) {
                Node w = parent.right;
                if (w != null && w.color == RED) {
                    w.color = BLACK;
                    parent.color = RED;
                    rotateLeft(parent);
                    w = parent.right;
                }
                if ((w.left == null || w.left.color == BLACK) && (w.right == null || w.right.color == BLACK)) {
                    w.color = RED;
                    x = parent;
                    parent = x.parent;
                } else {
                    if (w.right == null || w.right.color == BLACK) {
                        if (w.left != null) w.left.color = BLACK;
                        w.color = RED;
                        rotateRight(w);
                        w = parent.right;
                    }
                    w.color = parent.color;
                    parent.color = BLACK;
                    if (w.right != null) w.right.color = BLACK;
                    rotateLeft(parent);
                    x = root;
                }
            } else {
                Node w = parent.left;
                if (w != null &&  w.color == RED) {
                    w.color = BLACK;
                    parent.color = RED;
                    rotateRight(parent);
                    w = parent.left;
                }
                if ((w.right == null || w.right.color == BLACK) &&
                        (w.left == null || w.left.color == BLACK)) {
                    w.color = RED;
                    x = parent;
                    parent = x.parent;
                } else {
                    if (w.left == null || w.left.color == BLACK) {
                        if (w.right != null) w.right.color = BLACK;
                        w.color = RED;
                        rotateLeft(w);
                        w = parent.left;
                    }
                    w.color = parent.color;
                    parent.color = BLACK;
                    if (w.left != null) w.left.color = BLACK;
                    rotateRight(parent);
                    x = root;
                }
            }
        }
        if (x != null) x.color = BLACK;
    }


    private Node search(Node node, int key) {
        while (node != null && key != node.key) {
            if (key < node.key) node = node.left;
            else node = node.right;
        }

        return node;
    }

    public void inOrder() {
        inOrderPrint(root);

    }

    private void inOrderPrint(Node node) {
        if (node != null) {
            inOrderPrint(node.left);
            System.out.println("(" + node.key + ", " + (node.color == RED ? "R" : "B") + ")");
            inOrderPrint(node.right);
        }
    }

    public static void main(String[] args) {
        RED_BLACK_TREE tree = new RED_BLACK_TREE();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(25);
        tree.inOrder();
        System.out.println("------");
        tree.delete(20);
        tree.inOrder();
    }

}
