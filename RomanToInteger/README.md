# 13. Roman to Integer
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

## 概括
    把罗马数字转换成阿拉伯数字
    
    
## 解题思想
### 按照转换规律
1. 相同的数字连写,所表示的数等于这些数字相加得到的数,如：Ⅲ=3;
2. 小的数字在大的数字的右边,所表示的数等于这些数字相加得到的数, 如：Ⅷ=8,Ⅻ=12;
3. 小的数字（限于 I,X 和 C）在大的数字的左边,所表示的数等于大数减小数得到的数,如：Ⅳ=4,Ⅸ=9;
4. 正常使用时,连写的数字重复不得超过三次;

**优化**: 
如果可以把逻辑判断替换成三元运算符, 速度可能会快一点.

```java 
class Solution {
    public int romanToInt(String s) {
       if(null == s || "".equals(s))return 0;
        HashMap<Character, Integer> constMap = new HashMap<Character, Integer>();
        constMap.put('I', 1);
        constMap.put('V', 5);
        constMap.put('X', 10);
        constMap.put('L', 50);
        constMap.put('C', 100);
        constMap.put('D', 500);
        constMap.put('M', 1000);
        Character lastDigit = s.charAt(0) ;
        int lastNum = constMap.get(lastDigit);
        int decimalInt = 0;
        //每次看当前数字来操作上一个数字.
        for(int i =1 ; i < s.length(); i++){
            Character charTmp = s.charAt(i);
            int currentNum = constMap.get(charTmp);
            if( currentNum == lastNum ){
            	decimalInt += lastNum;
            }else if(currentNum > lastNum){
            	decimalInt -= lastNum ;
            }else if(currentNum < lastNum){
            	decimalInt += lastNum ;
            }
            lastNum = currentNum ;
        }
        return decimalInt+lastNum ;
    }
}

```