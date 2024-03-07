package com.anurag.BinaryTree;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}

public class BinaryTreeDistance {
    TreeNode root;

    int findDistance(TreeNode root, int node1, int node2) {
        TreeNode lca = findLCA(root, node1, node2);
        
        int distanceNode1 = findDistanceFromNode(lca, node1, 0);
        int distanceNode2 = findDistanceFromNode(lca, node2, 0);

        return distanceNode1 + distanceNode2;
    }

    private TreeNode findLCA(TreeNode root, int node1, int node2) {
        if (root == null) {
            return null;
        }

        if (root.val == node1 || root.val == node2) {
            return root;
        }

        TreeNode leftLCA = findLCA(root.left, node1, node2);
        TreeNode rightLCA = findLCA(root.right, node1, node2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    private int findDistanceFromNode(TreeNode root, int target, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.val == target) {
            return distance;
        }

        int leftDistance = findDistanceFromNode(root.left, target, distance + 1);
        int rightDistance = findDistanceFromNode(root.right, target, distance + 1);

        return (leftDistance != -1) ? leftDistance : rightDistance;
    }

    public static void main(String[] args) {
        BinaryTreeDistance tree = new BinaryTreeDistance();

        // Construct the example tree
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(4);

        int node1 = 5;
        int node2 = 1;

        int distance = tree.findDistance(tree.root, node1, node2);

        System.out.println("Minimum distance between nodes " + node1 + " and " + node2 + " is: " + distance);
    }
}

