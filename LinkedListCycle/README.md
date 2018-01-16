# 141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

## 概括
    检测一个链表是否存在循环

## 解题思想
### HashSet

最直接的想法还是Java无所不能的Hash相关的数据结构. 每个节点在内存中的内存地址唯一, 那么只要不断
把下一个节点加进去, 然后判断是否为空, 如果为空就结束, 如果不为空就判断是否已经存在.
然鹅, 这种效率十分低.
所以 **暴力膜, 不可取!** 
    
```java
public boolean hasCycle(ListNode head) {
    Set<ListNode> nodesSeen = new HashSet<>();
    while( head!=null ){
        if(nodesSeen.contains(head)){
            return true;
        }
        nodesSeen.add(head);
        head = head.next;
    }
    return false; 
}

```
### 暴力改数据

算法核心思想是: **更加暴力的膜!**. 上面算法太慢, 而我的目的只是让他通过测试, 所以根本不用管
原始数据的问题. 管他3721直接把他所有传进来的数据 `打上我们已经访问过的标记` , 一把索!
感觉 _Effective Java_ 作者的棺材板快压不住了. 这种方法不太严谨, 因为你不管怎么打标记, 还是有可能
和链表原来的数据一样.

```java 

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(null == head||head.next==null){
            return false;
        }
        ListNode current = head;
        ListNode next = null;
        while(true){
            next = current.next;
            if(next==null && current.val == Integer.MIN_VALUE){
                return true;
            }else if(next==null){
                return false;
            }
            current.val = Integer.MIN_VALUE;
            current.next = null;
            current = next;
        }
    }
}

```

### 快慢指针

一个快指针每次可以走2步, 一个慢指针每次可以走1步, 那么如果存在循环的话, 就会相遇.
数学证明

This math is inline $`a^2+b^2=c^2`$.

This is on a separate line

```math
a^2+b^2=c^2
```