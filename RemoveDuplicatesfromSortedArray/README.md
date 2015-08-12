
##Remove Duplicates from Sorted Array
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory. 

For example,
 Given input array nums = [1,1,2], 

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 



---
##解题思想
###想法1
 
 规律：
 ```
[1,1,1,2,3,3,4,5]

i=1 ; re *= 0 ; diff ^= 1
[1,1,1,2,3,3,4,5]
 * ^
i=2 ; re *= 1 ; diff ^= 2
[1,1,1,2,3,3,4,5]
   * ^
i=3 ; re *= 1 ; diff ^= 3
[1,1,1,2,3,3,4,5]
   *   ^
[1,2,1,2,3,3,4,5]
     * ^ 
i=4 ; re *= 1 ; diff ^= 3
[1,2,1,2,3,3,4,5]
     *   ^

 ```

---
用两个指针 
head:找到第一个不相等的下标
tail:找到第一个重复的值

	if(head比较前一个 不相等)
		if(head == (tail+1))
			两个指针同时前移
		else 
			用head的值替换tail+1内容
			tail++
	else(head比较前一个 相等)
		head++


