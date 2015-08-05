public class Solution {
    public int reverse(int x) {
	        if(x == 0 ||( x< 10 && x>-10))return x;
	       
	        int sign = 1;
	        if(x < 0){
	            sign = -1;
	            x = -x;
	        }
	        int len = 1 ;//数字的位数
	       
	        while(x/len>=10){
	           len*=10;
	        }
	        long firstcom = x%10*(long)len;
	        if(firstcom >=Integer.MAX_VALUE || firstcom<=Integer.MIN_VALUE)return 0;//现行判断
	        
	        int returnX = 0 ;
	        int base = 1;
	        while(x!=0){
	        	int leftDigit = x/len;
	        	long addLong = returnX+leftDigit*(long)base;
	        	if(addLong  >=Integer.MAX_VALUE || addLong<=Integer.MIN_VALUE)return 0;
	        	returnX=returnX+leftDigit*base;
	        	x=x%len;
	        	len = len/10;
	        	base*=10;
	        }
	         
	        return sign*returnX;
	    }
}