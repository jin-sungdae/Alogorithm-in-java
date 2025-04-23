package datastructure.tree;

public class AVL_TREE {
    static class Node {
        int key, height;
        Node left, right;

        public Node (int key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;
    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.key + " ");
            inorder(node.right);
        }
    }

    private int height(Node node) {
        return node != null ? node.height : 0;
    }

    private int getBalance(Node node) {
        return node != null ? height(node.right) - height(node.left) : 0;
    }

    private void updateHeight(Node node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;

    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        x.left = y;
        y.right = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        updateHeight(node);
        return balance(node);
    }

    private Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key){
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                Node successor = minValueNode(node.right);
                node.key = successor.key;
                node.right = delete(node.right, successor.key);
            }
        }

        if (node == null) return null;

        updateHeight(node);
        return balance(node);
    }

    private Node minValueNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private Node balance(Node node) {
        int balance = getBalance(node);

        // LL 왼쪽 회전
        if (balance > 1 && node.left != null && getBalance(node.left) >= 0)
            return rotateRight(node);

        // LR 좌측 자식 왼쪽 회전 -> 본인 오른쪽 회전
        if (balance > 1 && node.left != null && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RR 오른쪽 회전
        if (balance < -1 && node.right != null && getBalance(node.right) <= 0)
            return rotateLeft(node);

        // RL 우측 자식 오른쪽 회전 -> 본인 왼쪽 회전
        if (balance < -1 && node.right != null && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }


        public static void main(String[] args) {
            AVL_TREE tree = new AVL_TREE();

            // 삽입
            tree.insert(10);
            tree.insert(20);
            tree.insert(30);
            tree.insert(40);
            tree.insert(50);
            tree.insert(25);

            System.out.print("Inorder after insert: ");
            tree.inorder(); // 10 20 25 30 40 50

            // 삭제
            tree.delete(40);
            tree.delete(25);

            System.out.print("Inorder after delete: ");
            tree.inorder(); // 10 20 30 50
        }

}
