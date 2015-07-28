
##ZigZag Conversion 
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

##解题想法：
1.理解题目
	把两个倒叙链表的数字相加，返回一个倒叙的和数字链表

2.解题步骤
	1.先把两个链表的数字求和
	2.再把求和之后的数字逐个加入到链表中（采用尾插法）



