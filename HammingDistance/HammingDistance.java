public class Solution {
    public int hammingDistance(int x, int y) { 
	        int z = x^y;
	        int sum = 0 ;
	        String z_bit = Integer.toBinaryString(z);
	        for(int i = 0 ; i < z_bit.length() ; i++){
	            if(z_bit.charAt(i)=='1')sum++;
	        }
	        return sum;
	    }
}