public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map mp = new HashMap<Integer,Integer>();
        int maxEleIndex = 0 ;
        int maxVal = 0;
        for(int i = 0 ; i<len ; i++){
            Integer tempInt = new Integer(0);
            if(mp.containsKey(nums[i])){
                tempInt = (Integer)mp.get(nums[i]);
                tempInt++;
            }else{
                tempInt = 1;
            }
            mp.put(nums[i],tempInt);
            if(tempInt>=maxEleIndex){
                maxEleIndex = tempInt;
                maxVal = nums[i];
            }
        }
        return maxVal;
    }
}