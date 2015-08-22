public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k%len;
        if(k<=0)return ;
        if(len==1||len==k)return;
        int[] temp = new int[len];
        int n = len-k;
   
        int m = 0 ;
        for(int i = 0 ;i <len ; i++){
            //每次置换一个数字写入数组
            temp[i]=nums[i];
            if(i<k){
                nums[i]=nums[n];
                n++;
            }else{
                nums[i]=temp[m];
                m++;
            }
            
        }
}
}