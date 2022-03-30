package Leetcode;


import java.util.*;

public class day8 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean left = false, right = false;

        if (p == null && q == null)
            return true;

        assert p != null;
        if (p.val == q.val) {
            left = isSameTree(p.left, q.left);
            right = isSameTree(p.right, q.right);
        }
        return left && right;
    }

    public boolean isMirror(TreeNode n1,TreeNode n2){
        if((n1.left==null && n2.right==null)||(n1.right==null && n2.left==null))
            return true;
        if((n1.left==null || n2.right==null)||(n1.right==null || n2.left==null))
            return true;

        boolean left = false, right = false;

        if(n1.left.val==n2.right.val){
            left=isMirror(n1.left,n2.right);
            if(left)
                right=isMirror(n1.right,n2.left);
        }

        return left&&right;

    }


    public boolean isSymmetric(TreeNode root) {
        boolean left = false, right = false;

        if (root == null)
            return true;

        if(root.left!=null && root.right!=null && root.left.val==root.right.val){
            return isMirror(root.left,root.right);
        }
        return false;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();

        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.empty())
                    break;

                root = stack.pop();
                ans.add(root.val);
                root = root.right;

            }
        }
        return ans;
    }


}
