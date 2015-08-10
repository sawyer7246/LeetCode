public class Solution {
    public int removeDuplicates(int[] nums) {
	        int len = nums.length;
	        if(len==0)return 0;
	        int tempNum = nums[0] ;
	        int count = 0;
	        int times = 0;
	        
	        for(int i = 0 ; i<len ; i++){
	            if(tempNum==nums[i]){
	                times++;
	                if(times<3){
	                	nums[count]=nums[i];
	                    count++;
	                }
	            }else{
	                tempNum = nums[i];
	                times = 1;
	                nums[count]=nums[i];
	                count++;
	            }
	        }
	        
	        return count;
  }
}