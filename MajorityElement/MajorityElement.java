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

  	public int majorityElement2(int[] nums) {
         Arrays.sort(nums);
    return nums[nums.length/2];
    }



    public int majorityElement3(int[] nums) {
        // moore's voting algorithm
        // find candidate element
        if (nums.length == 1) return nums[0];
        int majorityIndex = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[majorityIndex]) count++;
            else count--;
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        // check if candidate is the majority element
        return nums[majorityIndex];
    }
}