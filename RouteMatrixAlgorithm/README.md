今天收到网易游戏的拒信, 心里有点失落, 更多是无奈吧, 各种deadline, 实在是没时间准备面试, 而且千里迢迢从香港坐火车到杭州, 也是够受的.

选择本身就是双向的, 本身对网易暖暖的游戏不太感冒, 也并不想去杭州.

Anyway, 此处不留爷, 自有留爷处.

这里记录下面试过程中的算法题: 水陆矩阵.

# 描述
给一个矩阵, 1代表陆地, 0代表海洋, 上下左右移动1步内的元素算是相邻的, 连在一起的1算是一块陆地.

           [{1, 1, 1, 1, 0},

           {0, 1, 0, 1, 0},

           {0, 1, 1, 0, 1}]

这道题后来查了下是亚马逊的面试题 [1], 具体可以通过链接看一下描述.

# 分析
面试时候想法是用`DP`, 但是其实我自己都没底, 最后大概说了下我的想法, 直观的想通过某个1的上下左右去找, 事实上是`DFS`的思想(笑), 但具体让我写代码没怎么完整实现, 所以趁着还有点印象, 又思考了下.

策略是从左上角, 按行优先遍历所有的元素. 如果发现是陆地, 就从这个陆地开始往右和往下迭代(`DFS`).

# 实现
具体实现有如下几个问题:

1. `Node`节点需要保留访问标记(当然也可以外部通过`HashSet`记录).

2. 如何在迭代过程中记录访问路径,这里我是通过在参数列表传一个`HashSet`引用, 如果是当前节点是陆地就自己加进去.

3. 如何定义陆地集合. 我是用`List<HashSet<String>>`来记录, `HashSet`中保存的是陆地的行列号字符串.

4. 如何匹配一轮`DFS`查找后返回的`HashSet`内容. 针对每个元素, 迭代返回的`HashSet`可能是属于某个`land`的一部分, 那么需要把它加入到这个`land`中. 这里只要判断`HashSet`是否和外部保存的`List<HashSet<String>>`中每个`Set`有没有交集.

# 代码
定义数据结构: LandMatrix 
```java
public class LandMatrix {
	public boolean isVisted = false;
	public boolean isLand = false ;
	public LandMatrix(){
	}
	public LandMatrix(boolean isLand){
		this.isLand = isLand ;
	}
	
	@Override
	public String toString() {
		return "isLand:"+isLand+",isVisted:"+isVisted;
	}
}
```
算法: LandMatrixAlgorithm
```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LandMatrixAlgorithm {

	static int MAX_DEPTH = 5;

	public static void main(String[] args) {
		List<ArrayList<LandMatrix>> matrix = new ArrayList<ArrayList<LandMatrix>>();
		int sizeOfMatrix = 1000;
		for (int i = 0; i < sizeOfMatrix; i++) {
			ArrayList<LandMatrix> tmpList = new ArrayList<LandMatrix>();
			matrix.add(tmpList);
			for (int k = 0; k < sizeOfMatrix; k++) {
				LandMatrix l1 = new LandMatrix();
				tmpList.add(l1);
			}
		}
		// 0-1
		// 0-3
		// 2-0,2-1,2-2,3-1
		// 3-3
		for (int m = 0; m < sizeOfMatrix; m++) {
			matrix.get((int) (Math.random() * sizeOfMatrix)).get((int) (Math.random() * sizeOfMatrix)).isLand = true;
		}
		// matrix.get(0).get(3).isLand = true;
		// matrix.get(2).get(0).isLand = true;
		// matrix.get(2).get(1).isLand = true;
		// matrix.get(2).get(2).isLand = true;
		// matrix.get(3).get(1).isLand = true;
		// matrix.get(3).get(3).isLand = true;

		// control the depth of stack
		int depth = 1;
		long start = System.currentTimeMillis();
		List<HashSet<String>> landsSet = new ArrayList<HashSet<String>>();
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.size(); j++) {
				HashSet<String> landSet = new HashSet<String>();
				DFS(matrix, i, j, depth, landSet);
				if (landSet.size() == 0) {
					continue;
				}
				boolean isIn = false;
				for (int k = 0; k < landsSet.size(); k++) {
					HashSet<String> testSet = new HashSet<String>();
					testSet.addAll(landsSet.get(k));
					testSet.retainAll(landSet);
					if (testSet.size() != 0) {
						landsSet.get(k).addAll(landSet);
						isIn = true;
					}
				}
				if (!isIn || landsSet.size() == 0) {
					landsSet.add(landSet);
				}
			}
		}
		System.out.println("Time:" + (System.currentTimeMillis() - start) + "\n" + landsSet);
	}

	public static void DFS(List<ArrayList<LandMatrix>> matrix, int i, int j, int depth, HashSet<String> landSet) {
		if (isEnd(matrix, i, j, depth) || matrix.get(i).get(j).isVisted) {
			return;
		}
		matrix.get(i).get(j).isVisted = true;
		if (matrix.get(i).get(j).isLand == false) {
			return;
		} else {
			// add to is lands
			landSet.add(i + "-" + j);
		}
		// RIGHT
		if (canMove(matrix, i + 1, j)) {
			DFS(matrix, i + 1, j, depth + 1, landSet);
		}
		// DOWN
		if (canMove(matrix, i, j + 1)) {
			DFS(matrix, i, j + 1, depth + 1, landSet);
		}
	}

	private static boolean canMove(List<ArrayList<LandMatrix>> matrix, int i, int j) {
		if (i < matrix.size() && j < matrix.get(i).size()) {
			return true;
		}
		return false;
	}

	private static boolean isEnd(List<ArrayList<LandMatrix>> matrix, int i, int j, int depth) {
		if (depth > LandMatrixAlgorithm.MAX_DEPTH) {
			return true;
		}
		return false;
	}

}
```











[1]:https://www.glassdoor.com/Interview/You-are-given-a-n-n-matrix-of-bits-1s-and-0s-where-1-represents-land-and-0-represents-water-Adjacent-1s-can-be-considere-QTN_354346.htm