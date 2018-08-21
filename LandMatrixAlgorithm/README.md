这是一道网易游戏一面算法题.

# 描述
给一个矩阵, 1代表陆地, 0代表海洋, 上下左右移动1步内的元素算是相邻的, 连在一起的1算是一块陆地.

           [{1, 1, 1, 1, 0},

           {0, 1, 0, 1, 0},

           {0, 1, 1, 0, 1}]

给定指定的陆地位置, 问该路径是否可达.

# 分析
利用`BFS`, 直接求出了所有的到达路径. `BFS`的想法是从一点开始检查所有可达附近陆地, 如果有陆地就该陆地加入`Queue`, 如果没有陆地就什么都不做.

# 实现
对于`BFS`还不是很熟练, 但是必须得练, 具体实现有如下几个问题:
1. `BFS`的实现利用了`Queue`, `java`里面的`queue`是从`LinkedList`过来的(因为他实现了`Queue`).
2. 判断是否可达很容易, 但是找到路径就有点麻烦, 利用了单链表, 保存他的父节点引用.

#代码
定义数据结构: LandMatrix
```java
public class LandMatrix {
	public boolean isVisted = false;
	public boolean isLand = false ;
	public int i = 0 ;
	public int j = 0 ;
	public LandMatrix prevs;
	
	public LandMatrix(int i, int j){
		this.i = i ;
		this.j = j ;
	}
	public LandMatrix(){
		
	}
	public LandMatrix(boolean isLand){
		this.isLand = isLand ;
	}
	
	public String toString() {
		return i+","+j+"=isLand:"+isLand+",isVisted:"+isVisted;
	}
}
```

算法: RouteMatrixAlgorithm2
```java

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteMatrixAlgorithm2 {

	public static void main(String[] args) {
		List<ArrayList<LandMatrix>> matrix = new ArrayList<ArrayList<LandMatrix>>();
		int sizeOfMatrix = 4;
		for (int i = 0; i < sizeOfMatrix; i++) {
			ArrayList<LandMatrix> tmpList = new ArrayList<LandMatrix>();
			matrix.add(tmpList);
			for (int k = 0; k < sizeOfMatrix; k++) {
				LandMatrix l1 = new LandMatrix(i, k);
				tmpList.add(l1);
			}
		}
		matrix.get(0).get(3).isLand = true;
		matrix.get(2).get(0).isLand = true;
		matrix.get(2).get(1).isLand = true;
		matrix.get(2).get(2).isLand = true;
		matrix.get(3).get(1).isLand = true;
		matrix.get(3).get(3).isLand = true;

		// control the depth of stack
		String target = "2,2";
		long start = System.currentTimeMillis();
		List<HashSet<String>> landsSet = new ArrayList<HashSet<String>>();
		for (int i = 0; i < matrix.size(); i++) {
			for (int j = 0; j < matrix.size(); j++) {
				LandMatrix head = new LandMatrix(i, j);
				if (!matrix.get(i).get(j).isLand && !matrix.get(i).get(j).isVisted) {
					continue;
				}
				LandMatrix back = BFS(matrix, i, j, target, head);
				if (null != back) {
					System.out.println("===================");
					while (back != null) {
						System.out.println(back);
						back = back.prevs;
					}
				}
			}
		}
		System.out.println("Time:" + (System.currentTimeMillis() - start) + "\n" + landsSet);
	}

	static int[] String2Coordinate(String str) {
		String[] str_split = str.split(",");
		return new int[] { Integer.parseInt(str_split[0]), Integer.parseInt(str_split[1]) };
	}

	static String[] step_direction = new String[] { "0,1", "1,0", };

	public static LandMatrix BFS(List<ArrayList<LandMatrix>> matrix, int i, int j, String target, LandMatrix head) {
		Queue<LandMatrix> q = new LinkedList<LandMatrix>();
		LandMatrix currentLand = null;
		LandMatrix prevs = head;
		// Put head into queue
		q.offer(matrix.get(i).get(j));
		matrix.get(i).get(j).isVisted = true;
		while (!q.isEmpty()) {
			currentLand = q.poll();
			prevs = currentLand;
			for (String tempDir : step_direction) {
				int[] tempDirInt = String2Coordinate(tempDir);
				int m = currentLand.i + tempDirInt[0];
				int n = currentLand.j + tempDirInt[1];
				if (canMove(matrix, m, n)) {
					if (matrix.get(m).get(n).isLand && !matrix.get(m).get(n).isVisted) {
						LandMatrix tmp = matrix.get(m).get(n);
						tmp.prevs = prevs;
						if (isDes(target, m, n)) {
							matrix.get(m).get(n).isVisted = true;
							return tmp;
						}
						q.offer(tmp);
					}
					matrix.get(m).get(n).isVisted = true;
				}
			}
		}
		return null;
	}

	private static boolean isDes(String target, int i, int j) {
		if ((i + "," + j).contentEquals(target)) {
			return true;
		}
		return false;
	}

	private static boolean canMove(List<ArrayList<LandMatrix>> matrix, int i, int j) {
		if (i > 0 && j > 0 && i < matrix.size() && j < matrix.get(i).size()) {
			return true;
		}
		return false;
	}

}
```




