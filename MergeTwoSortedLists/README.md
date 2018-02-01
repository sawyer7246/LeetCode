# 21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
    

## 概括
    合并两个有序链表.
    
    
## 解题思想
#### 1.双指针顺序查找
两个指针分别从两个链表中找, 比较大小, 如果A>B就把, B赋给ret, 反之亦反.




**注意**： 需要注意两点.

1. 其实不需要另外放一个指针接l1和l2, 本身就是引用, 但是放了便于理解.
2. 需要考虑鲁棒性,如果出现循环链表那么程序(打印输出时候)就崩了.

```java 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode ret = new ListNode(-1);
		ListNode head = ret;
		ListNode p1 = l1;
		ListNode p2 = l2;
		while (true) {
			if(p1 == null){
				ret.next = p2 ;
				break;
			}else if(p2 == null){
				ret.next = p1 ;
				break;
			}
			if (p1.val > p2.val) {
				ret.next = p2;
				p2 = p2.next ;
			} else {
				ret.next = p1;
				p1 = p1.next ;
			}
			ret = ret.next;
		}
		return head.next;
	
    }
}

```