
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len==0||len==1)return len;
        int tail = 0 ;//有重复的第一个下标
        
        for(int i = 1 ;i< len ;i++){
            //每次比较上一个,如果相等就head指针向前
            if(nums[tail] != nums[i]){
                //不相等
            	if(i != (tail+1)){
                	//如果tail的下一个不等于head,把head找的值赋给tail的下一个
                   nums[tail+1] = nums[i];
                }
            	//不管怎样tail还是继续走下去
                tail++;
            } 
        }
        return tail+1;
    }