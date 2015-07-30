##Length of Last Word   
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.


---
##解题思想
###想法1
1.用split函数，判断最后一个字符串数组元素是否符合规则，否则继续前进。
2.如果没有就返回0。
3.边界条件是空字符串和空格。


