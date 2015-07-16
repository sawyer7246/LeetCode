public class Solution {

	/*
	
	Palindrome Number

	Determine whether an integer is a palindrome. Do this without extra space.
	*/

    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        return  new StringBuffer(num).reverse().toString().equalsIgnoreCase(num);
    }


    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
            
        if(x == 0)
            return true;
        
        //获取x的位数
        int base = 1;
        
        while(x/base>=10){
            base*=10;
        }
        
        while(x!=0){
            int leftDigit = x/base;
            int rightDigit = x%10;
            
            if(leftDigit != rightDigit )
                return false;
            
            //返回中间的数
            x=(x%base)/10;
            base/=100;
        } 
        return true;
	}
}
