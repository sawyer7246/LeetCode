public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set set =  new HashSet();
        for(int i= 0 ;i<nums.length;i++){
         set.add(nums[i]); 
         if(set.size()!=(i+1))
            return true;
        }
        return false;
    }
}