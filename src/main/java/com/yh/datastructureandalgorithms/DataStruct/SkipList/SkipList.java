package com.yh.datastructureandalgorithms.DataStruct.SkipList;

import java.util.LinkedList;
import java.util.Random;

/**
 * 每个节点的forward里存的是当前节点的所有索引层的下一跳，forward[ 0 ]对应的是原链表里的下一跳，forward[ 1 ]是最后一层节点的下一跳位置，以此类推，也就是说访问head的forward[ levelCount-1 ]表示第一层索引的头结点。head是一个头结点，它的forward里存的是原链表以及索引层的头结点。
 */
public class SkipList {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        SkipList skipList=new SkipList();
        skipList.insert(2);
        skipList.insert(256);
        skipList.insert(232);
        skipList.insert(218);
        skipList.insert(12);
        skipList.insert(23);
        for(int i=14;i<1000;i++){
            skipList.insert(i);
        }

        System.out.println("插入耗时："+(System.currentTimeMillis()-start));
       System.out.println( skipList.find(800));
       System.out.println("查找耗时"+(System.currentTimeMillis()-start));
        skipList.printAll();
        /*long start=System.currentTimeMillis();
        LinkedList list=new LinkedList();
        for(int i=0;i<1000;i++){
            list.add(i);
        }
        System.out.println("插入耗时："+(System.currentTimeMillis()-start));
       for(int ii=0;ii<list.size();ii++){
           if(list.get(ii).equals(800)){}
           break;
       }

        System.out.println("查找耗时"+(System.currentTimeMillis()-start));*/
    }

    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    // 带头链表
    private Node head = new Node();

    private Random r = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    public void insert(int value) {
        int level = randomLevel();
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        Node [] update = new Node[level];
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // use update save node in search path
            update[i] = p;
        }

        // in search path node next node become new node forwords(next)
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        if (levelCount < level) {
            levelCount = level;
        }
    }

    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    // 随机 level 次，如果是奇数层数 +1，防止伪随机
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

}
