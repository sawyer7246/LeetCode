public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int numsLen = nums.length;
        int[] backArr=new int[2];
        //循环加入map中，每次加入之前判断是否有需要的值在Map得key中。  
        Map map = new HashMap();
        for(int i = 0 ; i< numsLen ;i++){
            Integer key = new Integer(nums[i]);
            Integer wantedKey = new Integer(target-nums[i]);
            if(map.containsKey(wantedKey)){
                backArr[0]=(int)map.get(wantedKey);
                backArr[1]=(i+1);
                return backArr;
            }
            map.put(key,1+i);            
        }
        return backArr;
    }
}