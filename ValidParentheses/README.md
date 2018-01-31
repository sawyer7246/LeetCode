# 20. Valid Parentheses

Given a string containing just the characters `'(', ')', '{', '}', '\[' and ']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"(\[)\]"` are not.


## 概括
    判断是否是合法的括号字符串
    
    
## 解题思想
#### 1.栈
如果是左括号就入栈, 右括号就出栈, 出栈时判断出栈元素是否和当前右括号对应.



**注意**： 需要注意两点.

1. 使用Map结构可以加快速度, 并且程序清晰容易理解.
2. 需要考虑鲁棒性,如果出现其他非法字符也要判断出来.

```java 
class Solution {
    public int strStr(String haystack, String needle) {
		if(null==s || "".equals(s)){
			return true ;
		}
		HashMap<Character, Character> bracket_map = new HashMap<Character, Character>();
		char left_crl = '(' ;
		char left_rec = '[' ;
		char left_cur = '{' ;
		char right_crl = ')' ;
		char right_rec = ']' ;
		char right_cur = '}' ;
		bracket_map.put(left_crl, right_crl);
		bracket_map.put(left_rec, right_rec);
		bracket_map.put(left_cur, right_cur);
		
		List<Character> stack = new ArrayList<Character>();
		for(char ch: s.toCharArray()){
			if(bracket_map.containsKey(ch)){
				stack.add(ch);
			}else {
				if(stack.size()==0 || ch != bracket_map.get(stack.remove(stack.size()-1))){
					return false ;
				}
			}
		}
		if(stack.size() != 0){
			return false ;
		}
		return true;
    }
}

```