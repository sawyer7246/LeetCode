# 141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

## 概括
    检测一个链表是否存在循环

## 解题思想
### `HashSet`
- Intuition 
    1. 最直接的想法还是Java无所不能的Hash相关的数据结构. 每个节点在内存中的内存地址唯一, 那么只要不断
    把下一个节点加进去, 然后判断是否为空, 如果为空就结束, 如果不为空就判断是否已经存在.
    然鹅, 这种效率十分低.
    所以`暴力膜,不可取`
    
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



