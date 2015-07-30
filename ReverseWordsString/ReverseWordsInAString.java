public class Solution {
    public String reverseWords(String s) {
        if(s==null||""==s)return "";
        String[] strArr = s.trim().split(" ");
        StringBuffer bf = new StringBuffer();
        for(int i=0 ; i<strArr.length;i++){
            if(strArr[i]==null||" ".equals(strArr[i])||"".equals(strArr[i]))continue;
            bf.insert(0," "+strArr[i]);
        }
        return bf.toString().trim();
    }
}