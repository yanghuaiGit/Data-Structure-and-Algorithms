package com.yh.datastructureandalgorithms.dataStruct.tree;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 二叉树节点
 */
@Data
@AllArgsConstructor
public class BinaryNode <T>{

    private T element;

    private BinaryNode<T> left;

    private BinaryNode<T> right;


    public BinaryNode(T element) {
        this(element,null,null);
    }
}
