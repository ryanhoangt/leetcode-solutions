// Question: https://leetcode.com/problems/binary-search-tree-iterator
// Created on: 2023-03-06

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> st;

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            st.add(node);
            node = node.left;
        }
    }

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        int res = top.val;

        pushAllLeft(top.right);
        
        return res;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */