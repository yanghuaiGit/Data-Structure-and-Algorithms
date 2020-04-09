package com.yh.datastructureandalgorithms.dataStruct.tree;


import lombok.Data;

/**
 * 平衡树节点
 */
@Data
public class AvlTreeNode<T> {

    public AvlTreeNode(T element) {
        this(element, null, null);
    }

    public AvlTreeNode(T element, AvlTreeNode<T> lt, AvlTreeNode<T> rt) {
        this.element = element;
        this.left = lt;
        this.right = rt;
        this.height = 0;
    }

    private T element;
    private AvlTreeNode<T> left;
    private AvlTreeNode<T> right;
    private int height;

}
