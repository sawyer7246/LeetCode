public class Solution {
    public int findComplement(int num) { 
        return (int) (Math.pow(2,Integer.toBinaryString(num).length())-1-num);
    }
}