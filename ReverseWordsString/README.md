##Reverse Words in a String
Given an input string, reverse the string word by word. 

For example,
 Given s = "the sky is blue",
 return "blue is sky the". 


---
##解题思想
###想法1
1.先用String的split方法去截取字符串。
2.循环String数组，用StringBuffer的insert方法头插，遇到空的数组元素就continue.

显然这不是最优的解法，但是java所带来的好处不也是开发的速度么？



