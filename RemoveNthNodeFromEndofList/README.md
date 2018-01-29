# 19. Remove Nth Node From End of List

Given a linked list, remove the nth node from the end of list and return its head.

For example,
    
    Given linked list: 1->2->3->4->5, and n = 2.

    After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid. Try to do this in one pass.


## 概括
    循环一趟删除链表的倒数第n个元素
    
    
## 解题思想
#### 1.双指针
用两个相隔n+1距离的指针,同时向下找,结束条件是前面的指针的下一个是空，
即,到了队尾.这时只要将后面的一个指针的下一个指向下一个的下一个, 返回头就可以了.
> 这道题当初考研时候有做过, 当时给我留下了很深的印象, 觉得太巧妙了.


**注意**： 需要注意两点.

1. 当给得n等于链表的第一个元素时候,需要单独判断,
我这里用了快指针已经为空,代表已经找到了数组的最后一个的下一个了,
所以, 直接返回头元素的下一个.
2. 另外, 这里需要注意的是直接给局部变量的指针, 而是要改局部变量指针指向
元素的指针, 即，改属性值.

```java 
class Solution {
    public String longestPalindrome(String s) {
		if (null == s || "".equals(s))
			return "";
		if (s.length() == 1)
			return s;
		if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1)) {
				return s;
			} else {
				return "" + s.charAt(0);
			}
		}
		StringBuffer r_s = new StringBuffer();
		for(int backward = s.length()-1; backward >= 0; backward-- ){
			r_s.append(s.charAt(backward));
		}
		int[][] mat = new int[s.length()][ s.length()];
		int len = s.length();
		int max = 0 ;
		int i_max = 0;
		for(int i = 0 ; i < len ; i++ ){
			char forwardChar = s.charAt(i);
			for(int k = 0; k < len ; k++ ){
				char backwardChar = r_s.charAt(k);
				if(forwardChar == backwardChar){ 
					if(i== 0 || k==0){
						mat[i][k] = 1 ;
						continue;
					}
					mat[i][k] = mat[i-1][k-1] + 1;
					if(((len-1-i == k-mat[i][k]+1)) && (max < mat[i][k])){
						max = mat[i][k];
						i_max = i ;
					}
				}else{
					mat[i][k] = 0;
				}
			}
		}
		return  s.substring(i_max-max+1, i_max+1) ;
    }
}

```