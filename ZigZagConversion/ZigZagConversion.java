public class Solution {
    public String convert(String s, int numRows) {
		   if("".equals(s)||numRows==1||s.length()<=numRows)return s;
			int strLen = s.length();
	        int[][] spanArr = new int[numRows][];//生产span数组
	        //3的规则是第一行是隔4个数字，第二行是隔2个，第三行是隔4个
	        //2的规则是第一行是隔4个数字，第二行是隔2个，第三行是隔4个
	        
	        int staticSpan = 2*numRows-2;//最大列距
	        int staticCol =2*strLen/staticSpan+1;//最大列长
	        for(int m=0 ;m<numRows&&m<strLen; m++){
	        	int[] insertArr=new int[staticCol];
	        	
	            int lineNo = m ;//行初始值
	            int[] stepArr =new int[]{staticSpan-2*m,2*m};//循环步长的数组
	            for(int n = 0 ; n<staticCol ;n++){
	            	if(n==0){
	            		insertArr[n]=lineNo;
	            	}else if(m==0 || m==(numRows-1)){
	            		//如果是最后一行或者是第一行
	            		lineNo+=staticSpan;
	            	
	            	}else {
	            		lineNo=(lineNo+stepArr[(n+1)%2]);
//	            		if(lineNo>=strLen)break;
//	            		insertArr[n]=lineNo;
	            	}
	            	if(lineNo>=strLen)break;
            		insertArr[n]=lineNo;
	               // spanArr[m][n]=lineNo;
	            }
	            spanArr[m]=insertArr;
	        }
	        
	       StringBuffer bf = new StringBuffer();
	       //循环下标数组
	       for(int k = 0 ; k<numRows ; k++){
	           int[] arrCol = spanArr[k];
	           if(arrCol==null)break;
	           for(int i=0 ; i<arrCol.length ;i++){
	        	   if(i!=0&&spanArr[k][i]==0){
	        		   continue;
	        	   }
	        	   bf.append(s.charAt(spanArr[k][i]));
	           }
	       }
	       return bf.toString();
	    }
}