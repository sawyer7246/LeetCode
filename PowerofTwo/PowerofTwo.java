public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)return false;
        //if( 1==n)return true;
        String binaryStr = Integer.toBinaryString(n);
        char[] charArr = binaryStr.toCharArray();
        boolean flag = false;
        for(int i = 0 ; i<charArr.length; i++){
            if(charArr[i]=='1'&&!flag){
                flag = true;
            }else if(flag && (charArr[i]!='0')){
                return false;
            }
        }
        return true;
        
    }
}