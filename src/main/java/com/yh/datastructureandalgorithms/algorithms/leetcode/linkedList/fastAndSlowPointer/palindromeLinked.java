package com.yh.datastructureandalgorithms.algorithms.leetcode.linkedList.fastAndSlowPointer;

import com.yh.datastructureandalgorithms.dataStruct.linkedlist.SNode;

/**
 * 使用快慢指针判断一个链表是否是一个回文链表
 * 空间复杂度O(1)
 * 时间复杂度O(1)
 */
public class palindromeLinked<T> {

    public boolean isPalindrome(SNode head) {
        if (head == null || head.getNext() == null) {
            return true;
        }

        SNode prev = null;
        SNode slow = head;
        SNode fast = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            SNode next = slow.getNext();
            slow.setNext(prev);
            prev = slow;
            slow = next;
        }
        //如果fast为null 代表此链表是偶数，就直接从slow当前节点进行判断即可
        //如果是奇数，则slow节点往下一个节点开始判断，因为是奇数，则中间节点是前面链表的末尾也是后面链表(从末尾开始数)的末尾 相等 不需要判断
        if (fast != null) {
            slow = slow.getNext();
        }

        while (slow != null) {
            if (!slow.getElement() .equals(prev.getElement()) ) {
                return false;
            }
            slow = slow.getNext();
            prev = prev.getNext();
        }

        return true;
    }
}
