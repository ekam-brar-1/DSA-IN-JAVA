// A simple Binary Search Tree implementation
public class BinaryTree {
    // Node inner class
    static class Node {
        int value;
        Node left, right;
        
        Node(int value) {
            this.value = value;
            left = right = null;
        }
    }
    
    private Node root;
    
    // Public insert method
    public void insert(int value) {
        root = insertRec(root, value);
    }
    
    // Recursive helper for insertion
    private Node insertRec(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insertRec(node.left, value);
        } else if (value > node.value) {
            node.right = insertRec(node.right, value);
        }
        // if value == node.value, do nothing (no duplicates)
        return node;
    }
    
    // In-order traversal: left, root, right
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }
    
    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.value + " ");
            inorderRec(node.right);
        }
    }
    
    // Pre-order traversal: root, left, right
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }
    
    private void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }
    
    // Post-order traversal: left, right, root
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }
    
    private void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.value + " ");
        }
    }
    
    // Simple search
    public boolean contains(int value) {
        return containsRec(root, value);
    }
    
    private boolean containsRec(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (value == node.value) {
            return true;
        }
        return (value < node.value)
            ? containsRec(node.left, value)
            : containsRec(node.right, value);
    }
    
    // Test it out
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int v : values) {
            tree.insert(v);
        }
        
        System.out.print("In-order traversal: ");
        tree.inorder();    // 20 30 40 50 60 70 80
        
        System.out.print("Pre-order traversal: ");
        tree.preorder();   // 50 30 20 40 70 60 80
        
        System.out.print("Post-order traversal: ");
        tree.postorder();  // 20 40 30 60 80 70 50
        
        System.out.println("Contains 40? " + tree.contains(40));  // true
        System.out.println("Contains 90? " + tree.contains(90));  // false
    }
}
