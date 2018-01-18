# 3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3. Note that the answer
must be a substring, `"pwke"` is a subsequence and not a substring.
 
## 概括
    找到最大子序列. 最直接的解法是用两层循环, 然而对于此类问题，通常可以使用 `双指针` 解决, leetcode上称之为 `滑动窗口`. 
    
## 解题思想
### 反向查询不重复的值(超时未通过)
不同于leetcode上的暴力破解, 我的想法是通过HashSet找重复的,然后一旦发现重复的，就从当前位置往回找,直到找到一个不存在重复的, 
并且在找的时候同时把节点加入外层HashSet, 之后跳出内部循环继续外部循环. 时间复杂度是 `n(O^2)` 
 
```java 
public static int lengthOfLongestSubstring(String s) {
		 	if(null == s||"".equals(s))return 0;
	        HashSet<Character> charSet = new HashSet<Character>();
	        HashSet<Character> charBackSet = new HashSet<Character>();
	        int max = 0 , cnt = 0;
	        for(int i = 0 ; i < s.length(); i++){
	        	Character tmpStr = s.charAt(i) ;
	        	if(!charSet.contains(tmpStr)){
	        		cnt++;
	        		charSet.add(tmpStr);
	        	}else{
	        		cnt = 0 ;
	        		charBackSet =new HashSet<Character>(); 
	        		//search backwards till find a unique one 
	        		for(int k = i ; k >= 0 ; k--){
	        			Character backStr = s.charAt(k);
	        			if(charBackSet.contains(backStr)){
	        				break;
	        			}else{
	        				cnt++;
	        				charBackSet.add(backStr);
	        			}
	        		}
	        		charSet = charBackSet ;
	        	}
	        	max = Math.max(max, cnt) ;
	        }
			return max;
	    }
```


### 滑动窗口
核心思想是同时用两个指针, 一个先找重复并加入HashSet, 一旦发现重复的就从启动另一个指针开始追之前那个指针.
目的是找到之前重复的那个位置,以便于继续前面的继续走下去. 
  >打个比方, 我要在一队战士中找到连在一起的`忠诚的`战士, 换言之, 也就是说里面可能混入了敌方间谍, 他会冒充我方战士, 并且我无法鉴别真伪。
    所以, 现在作为独立团团长的我, 开始和三营长从头看到尾找出最大不重复的战士, 我让他先别动, 我先找.
    于是顺着队伍走下去,一边走一遍喊名字，三营长同时也在记.
    不一会, 我发现了`一个`似曾相识的士兵, 那么我大喊 "三营长, 把我的意大利炮拿出来!把我之前这`一个`名字的士兵拉出来毙了" (__注意这时候三营长没有记新人名字__)
    由于, 我和三营长都是在纸上乱记得, 所以我们都不知道那个人在哪.
    于是三营长开始从头开始枪毙人. 并且每次三营长枪毙一个, 都会说"团长, 我把这个XX干掉了,你瞧瞧是不是那个人". 
    直到团长说, 好了那个人已经被干掉了, 你先待那别动, 我继续数.
    
**注意**
j和i的下标别搞错.

```java 
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
```