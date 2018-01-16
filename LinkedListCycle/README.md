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
    原始数据的问题. 管他3721直接把他所有传进来的数据 `打上我们已经访问过的标记` , 一把索,  

