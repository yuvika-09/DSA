import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal{
    static class TreeNode{
        int data;
        TreeNode left, right;
        TreeNode(int val){
            data = val;
            left = right = null;
        }
    }

    public static void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(TreeNode root){
        if(root == null) return ;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(TreeNode root){
        if(root == null) return ;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static int height(TreeNode root){
        if(root == null) return 0;
        int leftMax = height(root.left);
        int rightMax = height(root.right);
        return 1 + Math.max(leftMax , rightMax);
    }

    public static int count(TreeNode root){
        if(root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }

    public static boolean search(TreeNode root, int k){
        if(root == null) return false;
        if(root.data == k) return true;
        return search(root.left, k) || search(root.right, k);
    }

    public static void printLevel(TreeNode root, int k){
        if(root == null) return ;
        if(k == 1)
            System.out.println(root.data);
        else{
            printLevel(root.left, k-1);
            printLevel(root.right, k-1);
        }
    }

    public static int findMax(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        return Math.max(root.data , Math.max(leftMax,rightMax));
    }

    public static int countLeaves(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public static int sum(TreeNode root){
        if(root == null) return 0;
        return root.data + sum(root.left) + sum(root.right);
    }

    //insert new node in first available position (level-order insertion)
    public static TreeNode levelOrderInsertion(TreeNode root, int val){
        TreeNode newNode = new TreeNode(val);
        if(root == null) return newNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp.left == null) {
                temp.left = newNode;
                return root;
            } 
            else
                queue.add(temp.left);
            if (temp.right == null) {
                temp.right = newNode;
                return root;
            } 
            else
                queue.add(temp.right);
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Inorder traversal: ");
        inorder(root);
        System.out.println("\nPostorder traversal: ");
        postorder(root);
        System.out.println("\nPreorder traversal: ");
        preorder(root);
        System.out.println("\nHeight of tree is : " + height(root));
        System.out.println("No. of nodes in tree : " + count(root));
        System.out.println("Is 3 in the tree? " + search(root,3));
        System.out.println("Nodes at level 3 : ");
        printLevel(root, 3);
        System.out.println("Maximum value : " + findMax(root));
        System.out.println("No of leaf nodes : " + countLeaves(root));
        System.out.println("Sum of all nodes : " + sum(root));
        levelOrderInsertion(root,10);
        printLevel(root, 1); printLevel(root, 2); printLevel(root, 3);
    }
}