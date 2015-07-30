public class Solution {
    public int lengthOfLastWord(String s) {
        if(null == s || "".equals(s) ||" ".equals(s)){
            return 0;
        }
        String[] strArr = s.split(" ");
        
        int arrLen = strArr.length;
        for(int k = arrLen-1 ; k>=0 ; k--){
            if(" ".equals(s) || "".equals(s)){
                continue;
            }
            String tempStr = strArr[k];
            char initChar = tempStr.charAt(0);
            if(initChar>=65 || initChar<=90){
                return  tempStr.length();
            }
        }
        return 0;
    }
}