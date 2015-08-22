
##Rotate Array
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
---
##解题思想
###想法1
1. 找到规则：用相同len的数组保存复制滑动的数据，循环覆盖数字。
	
2. 	循环步骤
	保存到temp数组中。
	如果i<k，就取源数组后面的覆盖。
	如果i>=k，就取新数组的数字，覆盖。

3. 时间复杂度为 0(n) , 空间复杂度为o(n).

##Summary
奇怪的问题，为啥k可以大于源数组本身的长度，还shift个毛啊，不是说好从右开始k steps。
醉了。





