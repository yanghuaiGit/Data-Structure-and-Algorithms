package com.yh.datastructureandalgorithms.DataStruct.tree;

/**
 * @author lucky_yh
 * 2019/7/27 14:46
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.val = value;
    }

    private int getValue() {
        return val;
    }

    private TreeNode getLeft() {
        return left;
    }

    private TreeNode setLeft(TreeNode left) {
        this.left = left;
        return this;
    }

    private TreeNode getRight() {
        return right;
    }

    private TreeNode setRight(TreeNode right) {
        this.right = right;
        return this;
    }

}
