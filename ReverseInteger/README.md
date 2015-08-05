
##Reverse Integer
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

click to show spoilers.

Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

Update (2014-11-10):
Test cases had been added to test the overflow behavior.


---
##解题思想
###想法1
	真是日了动物园了，想问题还不是很周全！！
	最开始老是忘记取具体位数的数字的算法，然后各种纠结，脑子昏头了！
	之后，
	首先是小于10的问题，没有考虑到。
	其次，溢出问题只考虑了正的，但是始终没有办法解决判断是否溢出的问题，因为中间计算过程就已经溢出了，所以在计算的时候就要把数字转换成long.
	以为结束了，结果尼玛还有负溢出，WTF！！这可是ESAY难度啊！！

	后来优化了下判断，把运行时间刷到java算法成绩的前面，心情平复了许多，结果点开Cpp，我尼玛最差也就要10ms左右。

	一口老血。