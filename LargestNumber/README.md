## Largest Number
---
##解题思想
###想法1
1. 先把int数组转换成String。
2. 然后用collection.sort(),并且写一个comparator的内部类。
3. 先逐位判断，之后在最小长度之内可以比较出大小，就就返回大小；如果最小长度之内还是无法判断出大小，再分别判断两种情况
4. 每种情况又分三种情况，比如{128,12},{12,128}这种需要用长的那个数字对自身进行判断。比如{121,12},{12,121}需要比较12和(1)21,即截取同样长度继续迭代判断。

##Summary
 最后一次提交结果leetcode上不去了。。。

 写代码的过程中还遇到了一个JDK 1.7的兼容问题：
 	sort方法的排序从之前的归并排序变成了TimSort，这对comparator的要求更加高，必须得按照comparator的准则写：
`
a). sgn(compare(x, y)) == -sgn(compare(y, x)) 
b). (compare(x, y)>0) && (compare(y, z)>0) 意味着 compare(x, z)>0 
c). compare(x, y)==0 意味着对于任意的z：sgn(compare(x, z))==sgn(compare(y, z)) 均成立
`





