#Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array

---
##解题思想
###想法1
1.提示说是bit manipulation 但是我是用map实现的，所以速度有点慢。

2.因为他总是大于一半以上，所以问题的解决方法可以先排序，然后去向下去整的中间数，代码只有两行，十分简洁。




