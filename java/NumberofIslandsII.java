/*
	problem 305
	A 2d grid map of m rows and n columns is initially filled with water.
	We may perform an addLand operation which turns the water at position (row, col) into a land.
	Given a list of positions to operate,
	count the number of islands after each addLand operation.
	An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
	You may assume all four edges of the grid are all surrounded by water.

	Example Given m = 3, n = 3, 
	positions = [[0,0], [0,1], [1,2], [2,1]].
	Initially, the 2d grid grid is filled with water.
	(Assume 0 represents water and 1 represents land).
		0 0 0
		0 0 0
		0 0 0
	Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
		1 0 0
		0 0 0   Number of islands = 1
		0 0 0
	Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
		1 1 0
		0 0 0   Number of islands = 1
		0 0 0
	Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
		1 1 0
		0 0 1   Number of islands = 2
		0 0 0
	Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
		1 1 0
		0 0 1   Number of islands = 3
		0 1 0
	We return the result as an array: [1, 1, 2, 3]

	Note 0 is represented as the sea, 1 is represented as the island.
	If two 1 is adjacent, we consider them in the same island.
	We only consider up/down/left/right adjacent.
*/

import java.util.List;
import java.util.ArrayList;

public class NumberofIslandsII{

	static public void main(String[] args){
		Point[] p = {new Point(0,0), new Point(0,1), new Point(1,2), new Point(2,1)};
		System.out.println(numIslands2(3,3,p));
	}

	static private class Sea{
		private int[] id, size;
		private int n, m;

		public Sea(int n, int m){
			this.n = n;
			this.m = m;
			int size = n * m;
			this.id 	= new int[size];
			this.size	= new int[size];
			for(int i = 0; i < size; i++){
				this.id[i]		= -1;
				this.size[i]	= 0;
			}
		}

		public int find(int n){
			if(n < 0 || id[n] == -1) return -1;

			if(n != id[n]){
				id[n] = find(id[n]);
			}

			return id[n];
		}

		public boolean isConnected(int p, int q){
			if(id[p] == -1 || id[q] == -1) return false;
			return find(p) == find(q);
		}

		public boolean union(int p, int q){
			if(id[p] == -1 || id[q] == -1) return false;
			int pId = find(p);
			int qId = find(q);

			if(pId == qId) return true;

			if(size[pId] > size[qId]){
				id[qId] = pId;
				size[pId] += size[qId];
			}else{
				id[pId] = qId;
				size[qId] += size[pId];
			}

			return true;
		}

		public boolean setIsland(int n){
			if(id[n] != -1) return false;
			id[n] 	= n;
			size[n] = 1;
			return true;
		}

		public int ctoi(int x, int y){
			if(x >= n || x < 0 || y >= m || y < 0) return -1; 
			return x * n + y;
		}
	}
	// Definition for a point.
	static private class Point {
		int x;
		int y;
		Point(){x = 0; y = 0;}
		Point(int a, int b){x = a; y = b;}
	}


	static public List<Integer> numIslands2(int n, int m, Point[] operators){
		int islandCt = 0;
		Sea sea = new Sea(n, m);
		List<Integer> record = new ArrayList<Integer>();
		int[] xOffset = {-1, 0, 1, 0};
		int[] yOffset = {0, 1, 0, -1};

		for(Point p : operators){
			int islandsNum = -1, ct = 0, newIslandNum = sea.ctoi(p.x, p.y);
			sea.setIsland(newIslandNum);
			for(int i = 0, len = xOffset.length; i < len; i++){
				islandsNum = sea.find(sea.ctoi(p.x + xOffset[i], p.y + yOffset[i]));
				if(islandsNum != -1){
					if(ct > 0){
						if(islandsNum != newIslandNum){
							sea.union(islandsNum, newIslandNum);
							ct++;
						}
					}else{
						sea.union(islandsNum, newIslandNum);
						newIslandNum = islandsNum;
						ct++;
					}
				}
			}
			if(ct > 0){
				islandCt += ct - 1;
			}else{
				islandCt += 1;
			}
			record.add(islandCt);
		}
		return record;
	}
}