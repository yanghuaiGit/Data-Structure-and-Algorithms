package com.yh.datastructureandalgorithms.dataStruct.tree;

import java.nio.BufferUnderflowException;
import java.util.Objects;

/**
 * 二叉查找树
 */
public class BinarySearchTree<T extends Comparable<? super T>> {


    private BinaryNode<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return Objects.isNull(root);
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T fidMin() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMin(root).getElement();
    }

    public T fidMax() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return findMax(root).getElement();
    }

    public void insert(T x) {
        //需要将root节点修改 实际上 插入的这个方法传入的root节点就是树的root节点 因此是不会修改root节点的 还是set原来的值
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }


    /**
     * 如果删除的节点是叶子节点或者只有一个子节点 直接将其父节点的指向修改为删除节点的子节点即可 如果是叶子节点,没有子节点，那么指向的就是null
     * 如果删除的节点有2个节点，快速删除是找到删除节点的右节点中的最小节点即最左节点找到，递归的删除这个最左节点即第一种情况，再将删除节点的替换为其右节点的最左节点
     *
     * @param x
     * @param root
     * @return
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> root) {

        if (Objects.isNull(root)) {
            //删除的值没有找到 直接返回
            return null;
        }

        int result = x.compareTo(root.getElement());

        if(result<0){
            root.setLeft(remove(x,root.getLeft()));
        } else  if(result>0){
            root.setRight(remove(x,root.getRight()));
        }else if (Objects.nonNull(root.getLeft()) && Objects.nonNull(root.getRight())){
            //删除节点有两个儿子节点

            //将右最小节点替换
            root.setElement(findMin(root.getRight()).getElement());

            //递归删除右最小节点
            root.setRight(remove(root.getElement(),root.getRight()));
        }else {
            //只有一个节点 或者是叶子节点
            root = (Objects.nonNull(root.getLeft()))? root.getLeft():root.getRight();
        }

        return root;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> root) {
        if (Objects.isNull(root)) {
            return new BinaryNode<>(x, null, null);
        }

        int result = x.compareTo(root.getElement());

        if (result > 0) {
            root.setRight(insert(x, root.getRight()));
        } else if (result < 0) {
            root.setLeft(insert(x, root.getLeft()));
        } else {
            //插入的值相等  do nothing
        }

        return root;
    }


    public void printtree() {

    }


    /**
     * 用到了尾递归 实际上是可以使用while来进行修改的
     *
     * @param x
     * @param node
     * @return
     */
    private boolean contains(T x, BinaryNode<T> node) {
        if (Objects.isNull(node)) {
            return false;
        }
        int result = x.compareTo(node.getElement());

        if (result > 0) {
            return contains(x, node.getRight());
        } else if (result < 0) {
            return contains(x, node.getLeft());
        } else {
            return true;
        }
    }

    /**
     * 一直找到最左子节点即可
     * 非递归
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMin(BinaryNode node) {
        while (Objects.nonNull(node.getLeft())) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * 一直找到最右节点即可
     * 递归
     *
     * @param node
     * @return
     */
    private BinaryNode<T> findMax(BinaryNode node) {
        if (Objects.isNull(node)) {
            return null;
        }

        if (Objects.nonNull(node.getRight())) {
            return findMax(node.getRight());
        } else {
            return node;
        }

    }

}
