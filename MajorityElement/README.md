#Majority Element
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array

---
##解题思想
###想法1
1.提示说是bit manipulation 但是我是用map实现的，所以速度有点慢。

2.因为他总是大于一半以上，所以问题的解决方法可以先排序，然后去向下去整的中间数，代码只有两行，十分简洁。

3.还有一种Moore's Voting Algorithm,算法计数保留count，还Index，如果等于这个nums[index]，就count++,不等于就count--,如果减到0，就获取当前的数继续循环。
算法的精髓在于如果一个数大于半数那么最终按照这样加加减减最终这个数一定会保留下来。




