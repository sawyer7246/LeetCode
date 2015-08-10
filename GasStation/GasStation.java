import java.util.SortedMap;
import java.util.TreeMap;
public class Solution {
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
        
          if (total >= 0) return pos + 1;
        
          return -1;
        }
        
}