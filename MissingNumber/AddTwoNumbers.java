public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null)return 0;
        int len = nums.length ;//长度为len，即 n=len
        int n = len + 1 ;
        long count = ((n-1L)*n)/2L;
        long sum = 0L ;
        for(int i = 0 ; i < len ; i++ ){
            sum+=nums[i];
        }
        return new Long(count-sum).intValue();
    }
}