##Rotate Image 

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

---
##解题思想
###想法1
1.  题目要求是顺时针转90度，那么是这样的
```
	1234	d951
	5678 -> ea62
	9abc	fb73
	defg	gc84

2X2 举例：
	0 1 -> 2 0
	2 3	   3 1
	
位置转换关系：
	0->1 1->3
	2->0 3->2

```
初始转换：
	x=i*N+j 

位置转换关系：
	y=(j+1)*N-1-i
	
翻译转换：
	m=y/N n=y%N
 
 