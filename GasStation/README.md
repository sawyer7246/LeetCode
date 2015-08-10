##Gas Station 
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

---
##解题思想
###想法1
1. Greedy Algorithms(贪心算法)的O(N)的复杂度，因为有唯一解，所以一遍过。

	```java
	 public int canCompleteCircuit(int[] gas, int[] cost) {
        int pos = -1, curr = 0, total = 0;

        //如果从一个站出发，中途到油不够，不了一个站，那么就算从中间任意的站出发也是到不了的，所以不用回溯。
        //所以可以直接从接下来的一个站重新出发。
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];//当前有的汽油减去到下一个站消耗的
        
            curr += diff;
            total += diff;
        
            if (curr < 0) {
              // use up all the gas in current run
              // reset from the next one
              curr = 0;
              pos = i;
            }
          }
        
          if (total >= 0) return pos + 1;//判断如果油量剩余量大于等于0，那么就返回最后那个位置。
        
          return -1;
	    }
	```

2. 最开始想法比较简单，虽然也是贪心算法的思想：先排序，再从最大的油量的加油站走起，然而并没有什么卵用，因为他有唯一解，换言之，他要么有一个解，要么就没有解，所以从最大的那个开始并没有什么意义。看来我还是没有掌握贪心的精髓啊！！***继续努力！***

 算了，Time limit exceeded的二逼算法还是贴一下吧,比较还是学到了给*Map按照value排序*的方法 = _ = 

 ```java

import java.util.SortedMap;
import java.util.TreeMap;
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
	        //贪心算法 
	        //空车，选择一个点出发，让他能走完一圈 
	        //gas[0]是0第一个汽油站的油量  cost[0] 是0->1号汽油站需要的油量
	        
	        //算法思想：先排序从油量最多的汽油站开始尝试，
	        int gasLen = gas.length;
	        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	        for(int i = 0 ; i < gasLen ; i++){
	            map.put(i,gas[i]);
	        }
	        List<Map.Entry<Integer, Integer>> list_Data = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());  
	        Collections.sort(list_Data, new Comparator<Map.Entry<Integer, Integer>>()  
	          {   
	              public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2)  
	              {  
	               if(o2.getValue()!=null&&o1.getValue()!=null&&o2.getValue().compareTo(o1.getValue())>0){  
	                return 1;  
	               }else{  
	                return -1;  
	               }  
	              }  
	          });  
	        
	        Iterator it = list_Data.iterator();
	        while(it.hasNext()){
	        	Map.Entry<Integer, Integer> key = (Map.Entry<Integer, Integer>) it.next();
	        	Integer num = key.getKey() ;//获取下标
	        	//验证是否走得通
	        	if(canComplete(num,gas,cost))
	        		return num;
	        }
	        return -1;
	    }
	    
      private static boolean canComplete(int start,int[] gas, int[] cost){
	    	int len = gas.length;
	    	int gasTank = 0 ;
	    	int i = start;
	    	do{
	    		gasTank += gas[i];//加油
	    		gasTank-=cost[i];//开到下一个加油站
	    		if(gasTank<0){
	    			return false;
	    		}
	    		i=(i+1)%len;
	    	}while(i!=start);
	    	return true;
	    }
	    
	    
}
 	```