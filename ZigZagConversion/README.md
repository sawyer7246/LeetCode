
##ZigZag Conversion 
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


---
##解题思想
###想法1
1.找到规则：
---
step 4
0 1 2 3 4 5 6 7 8 9 10

line1 span 6
line2 span 3
line3 span 3
line4 span 6

0   6     12     18
1  57  11 13   1719
2 4 810   14 16 
3   9     15
---
step 3
0 1 2 3 4 5 6 7 8 9

0 4 8  
13579
2 6 10

line1 span 4
line2 span 2
line3 span 4
---
step 5
0 1 2 3 4 5 6 7 8 9 10 11 

0    8
1   79
2  6 10 
3 5  11 
4    12
---
`
step n

line1 2n-2
line2 2n-4
line3 2n-6
lineN 2n-2N>=0
`
---

2.处理特殊条件：传入空，numRows==1，字符串小于numRows这些都直接返回原字符串。

3.生产span二维数组。
	1.找到最大列距，和最大列长。
	2.外循环处理行，内循环处理列，按照规则的循环步长{staticSpan-2*m,2*m},逐个循环计算下一个下标。(`注意：加的过程中可能会溢出数组边界下标，所以得在循环加之前判断)

4.循环二维数组取值
5.返回StringBuffer()



