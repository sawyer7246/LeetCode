# 28. Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:
    
    Input: haystack = "aaaaa", needle = "bba"
    Output: -1


## 概括
    在一个字符串中找子串开始下标
    
    
## 解题思想
#### 1.双指针
使用两个相隔len(substr)-1距离的指针, 同时向下找, 内部循环是一旦发现有相同的头尾的元素
就开始用内部的offset开始收缩, 一旦offset碰头就返回慢的指针下标.



**注意**： 需要注意两点.

1. 下标控制(这次比之前好多了).
2. 不要忘记内循环零时变量置空(offset = 0).

```java 
class Solution {
    public int strStr(String haystack, String needle) {
		if (null == haystack || null == needle || needle.length() > haystack.length()) {
			return -1;
		}
		if ("".equals(haystack) || "".equals(needle) || haystack.equals(needle)) {
			return 0;
		}
		int StrLen = haystack.length();
		int subStrLen = needle.length();
		int fastIndex = subStrLen - 1;
		int slowIndex = 0;
		int offset = 0;
		while (fastIndex < StrLen) {
			while (haystack.charAt(slowIndex + offset) == needle.charAt(offset)
					&& haystack.charAt(fastIndex - offset) == needle.charAt(subStrLen - 1 - offset)) {
				if (offset + 1 >= subStrLen - 1 - offset) {
					return slowIndex;
				}
				offset++;
			}
			offset = 0;
			fastIndex++;
			slowIndex++;
		}
		return -1;
    }
}

```