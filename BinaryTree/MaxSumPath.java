package com.anurag.BinaryTree;

class TreeNodeMSP {
    int val;
    TreeNodeMSP left, right;

    public TreeNodeMSP(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

class MaxSumPath {
    static int maxSum = Integer.MIN_VALUE;
    static TreeNodeMSP maxLeaf = null;

    public static TreeNodeMSP findMaxSumPath(TreeNodeMSP root) {
        if (root == null) {
            return null;
        }

        // Find the maximum sum path using DFS
        findMaxSumPathHelper(root, 0);

        return maxLeaf;
    }

    private static void findMaxSumPathHelper(TreeNodeMSP node, int currentSum) {
        if (node == null) {
            return;
        }

        currentSum += node.val;

        // If the current node is a leaf and the path sum is greater than the maxSum
        if (node.left == null && node.right == null && currentSum > maxSum) {
            maxSum = currentSum;
            maxLeaf = node;
        }

        // Recursively explore left and right subtrees
        findMaxSumPathHelper(node.left, currentSum);
        findMaxSumPathHelper(node.right, currentSum);
    }

    public static void main(String[] args) {
        // Example usage:
        // Construct a sample binary tree
        //        10
        //       / \
        //      2   10
        //     / \    \
        //    20  1   -25
        //              / \
        //             3   4
    	TreeNodeMSP root = new TreeNodeMSP(10);
        root.left = new TreeNodeMSP(2);
        root.right = new TreeNodeMSP(10);
        root.left.left = new TreeNodeMSP(20);
        root.left.right = new TreeNodeMSP(1);
        root.right.right = new TreeNodeMSP(-25);
        root.right.right.left = new TreeNodeMSP(3);
        root.right.right.right = new TreeNodeMSP(4);

        // Find the maximum sum leaf-to-root path
        TreeNodeMSP maxSumLeaf = findMaxSumPath(root);

        // Print the result
        System.out.println("Maximum Sum: " + maxSum);
        System.out.print("Path: ");
        printPath(maxSumLeaf);
    }

    private static void printPath(TreeNodeMSP leaf) {
        if (leaf == null) {
            return;
        }

        // Recursively print the path from the leaf to the root
        printPath(leaf.left);
        System.out.print(leaf.val + " ");
    }
}

