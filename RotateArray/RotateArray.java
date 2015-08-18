public class Solution {
    public void rotate(int[] nums, int k) {
            if(k<=0)return ;
            int len = nums.length;
            if(len==1)return;
            int[] temp = new int[len];
            int m = len-1-k;
            int n = 0 ;
            for(int i = 0 ;i <len ; i++){
                //每次置换一个数字写入数组
                if(i<k){
                    temp[i]=nums[i];
                    nums[i]=nums[m];
                }else{
                    nums[i]=temp[n];
                    n++;
                }
                
            }
    }
}