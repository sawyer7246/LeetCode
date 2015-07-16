##Palindrome Number 
Determine whether an integer is a palindrome. Do this without extra space.

---
##解题思想
###1.直接利用java反转字符的方法，但是显然这个方法对于 *回文* 这种形式更加通用，而不是针对于Integer类型。

###2.先获取Integer的，如果1100就返回1000，然后在循环内取最高位和最低位，看是否相等，不等就直接跳出返回False,如果相等，把当前的数去头去尾' x=(x%base)/10;'，之后底少两位，继续循环，直到中间的数为0，结束循环返回'true'。


