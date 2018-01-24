# 14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

 
## 概括
    找多个字符串最长前缀. 
    
## 解题思想
### 自己的不完善循环一次法\[已通过]
同时比较数组第一个下标, 不想等就结束循环.
 
```java 
class Solution {
    public String longestCommonPrefix(String[] strs) {
       
        if(null == strs || strs.length==0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        if(strs.length == 2 && strs[0].equals(strs[1])){
        	return strs[0];
        }
        int len = strs.length ;
        if("".equals(strs[0])){
        	return "";
        }
        String prefix_str = strs[0].charAt(0)+"" ;
        int prefix_index = 0 ;
        while(true){
            for(int k =0; k < len; k++){
            	if("".equals(strs[k])){
            		return "";
            	}
                if(prefix_index>=strs[k].length()||!prefix_str.equals(strs[k].substring(0,prefix_index+1))){
                    return strs[0].substring(0,prefix_index);
                }
            }
            prefix_index++;
            if(prefix_index == 0){
            	return "";
            }
            if(prefix_index>=strs[0].length()){
            	return prefix_str;
            }
            prefix_str = strs[0].substring(0,prefix_index+1);
        }
    
    }
}
```

### 优雅地循环一次法
核心思想： 拿前面一个当后面的前缀,不断截取找到后一个最大相同前缀.

它有两个特殊之处:
1. 用indexOf!=0 找最大前缀. 因为等于0就相当于找到了第一个index, 否则返回-1. 
2. 然后不断减少prefix去匹配当前字符串.


```java 
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String str : strs) {
            while(str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
```