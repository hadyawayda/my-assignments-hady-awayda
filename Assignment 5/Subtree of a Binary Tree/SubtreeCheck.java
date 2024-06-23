// To determine if a binary tree is a subtree of another binary tree, we can use a recursive approach. The idea is to traverse the main tree and check if the subtree starting from any node in the main tree matches the given subtree.

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class SubtreeCheck {

    // Function to check if two binary trees are identical
    public static boolean areIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.val == root2.val &&
                areIdentical(root1.left, root2.left) &&
                areIdentical(root1.right, root2.right));
    }

    // Function to check if a binary tree is a subtree of another binary tree
    public static boolean isSubtree(TreeNode mainTree, TreeNode subTree) {
        if (subTree == null) {
            return true;
        }

        if (mainTree == null) {
            return false;
        }

        if (areIdentical(mainTree, subTree)) {
            return true;
        }

        return isSubtree(mainTree.left, subTree) || isSubtree(mainTree.right, subTree);
    }

    // Driver method to test above functions
    public static void main(String[] args) {
        TreeNode mainTree = new TreeNode(26);
        mainTree.right = new TreeNode(3);
        mainTree.right.right = new TreeNode(3);
        mainTree.left = new TreeNode(10);
        mainTree.left.left = new TreeNode(4);
        mainTree.left.left.right = new TreeNode(30);
        mainTree.left.right = new TreeNode(6);

        TreeNode subTree = new TreeNode(10);
        subTree.right = new TreeNode(6);
        subTree.left = new TreeNode(4);
        subTree.left.right = new TreeNode(30);

        if (isSubtree(mainTree, subTree)) {
            System.out.println("The subtree is part of the main tree.");
        } else {
            System.out.println("The subtree is NOT part of the main tree.");
        }
    }
}

// Explanation
// TreeNode Class:

// A simple class to define a node in the binary tree, with an integer value and left and right child nodes.
// areIdentical Method:

// This method checks if two binary trees are identical. Two trees are identical if they have the same structure and node values.
// The base cases handle null nodes: if both nodes are null, they are identical. If one node is null and the other is not, they are not identical.
// Recursively check the left and right subtrees.
// isSubtree Method:

// This method checks if subTree is a subtree of mainTree.
// If subTree is null, it is always a subtree.
// If mainTree is null, subTree cannot be a subtree.
// Check if the trees rooted at mainTree and subTree are identical using areIdentical.
// Recursively check the left and right subtrees of mainTree.
// Driver Method:

// Construct the main tree and the subtree.
// Call isSubtree to check if subTree is a subtree of mainTree.
// Print the result.
// Time and Space Complexity
// Time Complexity: O(N * M), where N is the number of nodes in the main tree and M is the number of nodes in the subtree. In the worst case, we compare every node in the main tree with every node in the subtree.
// Space Complexity: O(H), where H is the height of the main tree. This is due to the recursion stack used in the recursive calls. In the worst case, the space complexity can be O(N) if the tree is skewed.
// This implementation efficiently checks if one binary tree is a subtree of another using a recursive approach.