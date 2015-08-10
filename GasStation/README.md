##Gas Station 
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.

---
##解题思想
###想法1
1. O(N)的复杂度，因为有唯一解，所以一遍过。

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

 