##Power of Two  
Given an integer, write a function to determine if it is a power of two.

---
##解题思想
###想法1
1.利用java的Integer.toBinaryString(n),把整型转换成二进制字符串;
2.如果这个数小于0，直接返回false;
3.判断这个字符串是不是从左到到，除了最左边的是1，其他的都是0，如果存在不为0的就返回false;
4.如果循环结束，返回true;



