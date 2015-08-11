public class Solution {
    public void rotate(int[][] matrix) {
      
        int len = matrix[0].length;
        if(len==1)return ;
        int[][] tempArr = new int[len][len]; 
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0 ; i <len ; i++ ){
            for(int j = 0 ; j < len ; j++){
                //计算放的位置
                int pos = j+i*len;
                int newPos = (j+1)*len-i-1;
                int m = newPos/len;
                int n = newPos%len;
                
                //覆盖之前先保存
                set.add(newPos);
                tempArr[m][n]=matrix[m][n];
                if(set.contains(pos)){
              matrix[m][n] = tempArr[i][j];
                }else{
                  matrix[m][n] = matrix[i][j];
                }
            }
        }
    }
}