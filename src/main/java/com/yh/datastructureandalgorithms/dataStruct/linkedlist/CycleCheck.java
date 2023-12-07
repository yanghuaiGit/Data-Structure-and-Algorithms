/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yh.datastructureandalgorithms.dataStruct.linkedlist;

/**
 * 检测单链表是否有环
 * 快慢指针，只要有环，那么快指针一定会指向慢指针
 */
public class CycleCheck {
    public static void main(String[] args) {
        SNode<Integer> head = new SNode<>(1);
        head.next(head);
        System.out.println(hasCycle(head));

        SNode<Integer> integerSNode = new SNode<>(5);
        head
                .next(new SNode<Integer>(2))
                .next(new SNode<Integer>(3))
                .next(new SNode<Integer>(4))
                .next(integerSNode)
                .next(integerSNode)
        ;
        System.out.println(hasCycle(head));
        head
                .next(new SNode<Integer>(2))
                .next(new SNode<Integer>(3))
                .next(new SNode<Integer>(4))
                .next(new SNode<Integer>(5))
                .next(new SNode<Integer>(6))
        ;
        System.out.println(hasCycle(head));
    }


    public static boolean hasCycle(SNode sNode) {
        if (sNode == null || sNode.getNext() == null) {
            return false;
        }
        SNode slow = sNode.getNext();
        SNode fast = sNode.getNext().getNext();

        while (slow != fast) {
            if (fast == null || fast.getNext() == null) {
                return false;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return true;
    }
}
