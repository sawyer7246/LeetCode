# 17. Letter Combinations of a Phone Number
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![img](./1.png)
 
## 概括
    找到数字代表字母的所有可能组合. 
    
## 解题思想
### FIFO\[已通过]
初始化有一个空字符串的链表,然后从开始循环数字,把每个数字代表的字母循环的FIFO的加到链表中.
 
```java 
class Solution {
    	public static List<String> letterCombinations(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		if (null == digits || "".equals(digits)) {
			return ans;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}
}
```