public class Solution {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        return  new StringBuffer(num).reverse().toString().equalsIgnoreCase(num);
    }
}