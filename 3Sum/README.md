# 15. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

```
For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```
 
## 概括
    找出三数之和等于0. 
    
## 解题思想

### 利用Hash结构穷举\[超时]
穷举两个之后去之前建立的map找第三个差.

```java 
public class Solution {
     public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	if(nums.length == 0){
    		return ret ;
    	}
    	Map<Integer, Integer> singleMap = new HashMap<Integer, Integer>();
    	for(int i = 0 ; i< nums.length ; i++){
    		singleMap.put(nums[i], i);
    	}
    	HashSet<String> threeSumSet = new HashSet<String>();
    	for(int i = 0 ; i < nums.length ; i++){
    		for(int k = i+1 ; k < nums.length ; k++){
    			Integer subtractNum = 0-nums[i]-nums[k] ;
    			if(!singleMap.containsKey(subtractNum)){
    				continue ;
    			}
    			int index = singleMap.get(subtractNum) ;
    			if( index==i || index == k){
    				continue ;
    			}
    			List<Integer> tmpArr = new ArrayList<Integer>();
    			tmpArr.add(nums[i]);
    			tmpArr.add(nums[k]);
    			tmpArr.add(0-nums[i]-nums[k]);
    			Collections.sort(tmpArr);
    			String concatStr = Arrays.toString(tmpArr.toArray());
    			if(!threeSumSet.contains(concatStr)){
    				threeSumSet.add(concatStr);
    				ret.add(tmpArr);
    			}
    		}
    	}
    	return ret ;
    }
}
```

### 排序之后前后找
解题思想: 最开始使用最直观的解法，穷举两个之后去之前建立的map找第三个差,但是这种方法存在很多重复的计算,
所以这个算法`建立在排序的基础上,这样就可以省去很多重复的集合`. 虽然之前的算法` o(3n^2+n)` , 后面一种时间复杂度是 ` O(n^2) ` 

**注意**: 外层循环的终止条件是 i+2 , 因为内部循环每次往前找两个, 这两个值是通过两个指针头尾出发碰头找.
另外,很重要一点是不管是外部循环还是内部循环,都要去除重复值.
 
```java 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i + 2 < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
            continue;
        }
        int j = i + 1, k = nums.length - 1;  
        int target = -nums[i];
        while (j < k) {
            if (nums[j] + nums[k] == target) {
                res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                j++;
                k--;
                while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
            } else if (nums[j] + nums[k] > target) {
                k--;
            } else {
                j++;
            }
        }
    }
    return res;
}
}
```

