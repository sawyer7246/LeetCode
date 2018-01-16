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