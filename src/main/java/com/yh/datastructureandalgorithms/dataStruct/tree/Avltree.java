package com.yh.datastructureandalgorithms.dataStruct.tree;

/**
 * 平衡二叉搜索树
 * https://www.jianshu.com/p/65c90aa1236d
 * https://upload-images.jianshu.io/upload_images/735527-4ad732e6f96fcdb3.jpg?imageMogr2/auto-orient/strip|imageView2/2/format/webp
 */
public class Avltree<T extends Comparable<? super T>> {

    private AvlTreeNode<T> root;

    public Avltree() {
        root = null;
    }

    public Avltree(AvlTreeNode<T> root) {
        this.root = root;
    }

    private int height(AvlTreeNode<T> t) {
        return t == null ? -1 : t.getHeight();
    }


    private AvlTreeNode<T> insert(T x, AvlTreeNode<T> t) {
        if (t == null) {
            return new AvlTreeNode<>(x, null, null);
        }


        int compareResult = x.compareTo(t.getElement());

        if (compareResult < 0) {
            t.setLeft(insert(x, t.getLeft()));
        } else if (compareResult > 0) {
            t.setRight(insert(x, t.getRight()));
        } else {
            //相同 do nothing
        }
        return balance(t);

    }

    private AvlTreeNode<T> balance(AvlTreeNode<T> t) {
        if (t == null) {
            return t;
        }
        if (height(t.getLeft()) - height(t.getRight()) > 1) {
            //不平衡 肯定是加了或减了一个节点  >= 其中=就是在左节点高度为1 右节点高度为0，右节点减少了一个，高度为-1.此时不平衡导致的
            //        O                O
            //        / \              /
            //       O   O   ===>    O
            //     /\              / \
            //   O  O             O  O

            //左边节点高于右边节点 即左左 左右情况 一定是左边子树加了一层或者右边节点减了一层
            //对于不平衡的节点由平衡变为不平衡，那么考虑左边节点增加一层的情况下，肯定是左边一层的节点加了一层，那么就是t.getLeft的节点加了一层，
            // 需要判断是t.getLeft的左节点还是右节点加了一层 如果是t.getLeft>t.getRight 那么就是左边节点加了就是左左，如果是右边高就是双旋转
            //相等是上面如图的情形 是右边节点少了一层

            //左左
            if (height(t.getLeft().getLeft()) >= height(t.getLeft().getRight())) {
                t = rightRotation(t);
            } else {
                //左右case2
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.getRight()) - height(t.getLeft()) > 1) {
            //右右
            if (height(t.getRight().getRight()) >= height(t.getRight().getLeft())) {
                t = leftRotation(t);
            } else {
                //右左 case3
                t = doubleWithRightChild(t);
            }
        }
        t.setHeight(Math.max(height(t.getLeft()), height(t.getRight())) + 1);
        return t;
    }

    private AvlTreeNode<T> doubleWithRightChild(AvlTreeNode<T> t) {
        t.setRight(rightRotation(t.getRight()));
        return leftRotation(t);
    }

    private AvlTreeNode<T> doubleWithLeftChild(AvlTreeNode<T> k3) {
        k3.setLeft(leftRotation(k3.getLeft()));
        return rightRotation(k3);
    }

    private AvlTreeNode<T> leftRotation(AvlTreeNode<T> x) {
        AvlTreeNode<T> right = x.getRight();
        AvlTreeNode<T> left = right.getLeft();
        right.setLeft(x);
        x.setRight(left);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        right.setHeight(Math.max(x.getHeight(), height(right.getRight())) + 1);
        return right;
    }


    private AvlTreeNode<T> rightRotation(AvlTreeNode<T> k2) {
        AvlTreeNode<T> k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
        k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }


}
