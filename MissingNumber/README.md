
## 268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.


##解题想法：
1.理解题目
	输入一个首项为0的等差数列，公差为1，项数为n+1，求缺少第几项。

2.解题步骤
	1.先用等差数列求和公式，得到该数列之和。
	2.循环累加求输入数列和，公式:Sn=na1+n(n-1)d/2
	3.返回最终之差。

3.遇到的问题
	1.题目没说明是无序的，所以想到比较笨的方法去解决。
	2.提前考虑到可能溢出的问题，用了Long,可是抛出了转换错。
	3。



