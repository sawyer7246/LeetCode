public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<=0)return false;
        Map<Integer,Integer>  allMap = new HashMap<Integer,Integer> ();
         for( int i =0 ; i < nums.length ;i++){
            //以k为大小的Map去新增，模拟一个队列，先进先出
            if(allMap.keySet().contains(nums[i])&&(Math.abs((allMap.get(nums[i])-i)))<=k){
             return true;
            }
            allMap.put(nums[i],i);
         }
         return false;
    }
}