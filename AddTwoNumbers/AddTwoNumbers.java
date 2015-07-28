/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long num_1 = 0 ;
            long num_2 = 0 ; 
            ListNode tempNode = l1 ;
            long i = 0;
            while(tempNode!=null){
            	if(i == 0){
            		num_1+=(tempNode.val+i*10);
            	}else{
            		long addVal =  tempNode.val ;
            		for(int m = 0 ; m < i ;m++){
            			addVal*=10;
            		}
            		num_1+=addVal;
            	}
                tempNode = tempNode.next;
                i++;
            }
            i=0;
            tempNode = l2 ;
            while(tempNode!=null){
            	if(i == 0){
            		num_2+=(tempNode.val+i*10);
            	}else{
            		long addVal =  tempNode.val ;
            		for(int m = 0 ; m < i ;m++){
            			addVal*=10;
            		}
            		num_2+=addVal;
            	}
                tempNode = tempNode.next;
                i++;
            }
            String numsStr = (num_2+num_1)+"";
            ListNode returnNode = new ListNode(-1);
            ListNode tempNode2 = new ListNode(-1);//保存最后一个节点
            for(int k =  numsStr.length() -1 ;k >=0;k--){
                Integer val =new Integer(numsStr.charAt(k)+"");
                if(k == numsStr.length() -1){
                    returnNode.next = new ListNode(val);//下一个节点
                    tempNode2 =  returnNode.next ;//保最后一个节点到零时对象
                }else{
                	ListNode node = new ListNode(val);//创建当前对象
                	tempNode2.next = node;//把新对象放到临时对象的后面去
                	tempNode2= tempNode2.next;//
                }
            }
            
            return returnNode.next;
        }
}