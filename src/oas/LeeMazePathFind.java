package oas;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class NodeL
{
	int x, y, d;

	NodeL(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.d = dist;
	}
};

public class LeeMazePathFind {
	
	static final int row[] = { -1, 0, 0, 1 };
	static final int col[] = { 0, -1, 1, 0 };
	public static boolean isValid(Integer path[][], boolean marked[][],
														int row, int col,int R, int C)
		{
			return (row >= 0) && (row < R) && (col >= 0) && (col < C)
						   && (path[row][col] == 1 || path[row][col] == 9) && !marked[row][col] ;
		}

		public static int BreadthFirst(int i, int j, int x, int y,int R, int C,Integer path[][])
		{
			
			boolean[][] marked = new boolean[R][C];
			Queue<NodeL> queue = new ArrayDeque<>();

			marked[i][j] = true;
			queue.add(new NodeL(i, j, 0));

			int minDist = Integer.MAX_VALUE;

			while (!queue.isEmpty())
			{
				NodeL node = queue.poll();

				i = node.x;
				j = node.y;
				int dist = node.d;

				if (i == x && j == y) {
					minDist = dist;
					break;
				}

				for (int k = 0; k < 4; k++)
				{
					if (isValid(path, marked, i + row[k], j + col[k],R,C)) {
						marked[i + row[k]][j + col[k]] = true;
						queue.add(new NodeL(i + row[k], j + col[k], dist + 1));
					}
				}
			}

			if (minDist != Integer.MAX_VALUE) {
				return minDist;
			}
			else {
				return -1;
			}
		}


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        int minDistance = -1;
        Integer[][] path = new Integer[numRows][numColumns];
        int i=0,j=0;
        
        //Convert Given 'area' list in to 2D array.
        //path[numRows][numColumns]
        int src_x = 0, src_y = 0;
        
        for(i=0;i<numRows;i++){
        	for(j=0;j<numColumns;j++){
        		path[i][j] = area.get(i).get(j);
        		
        		if(path[i][j] == 9){
        			src_x = i;
        			src_y = j;
        		}
        	}
        }

        minDistance = BreadthFirst(0, 0, src_x, src_y,numRows,numColumns,path);
        return minDistance;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LeeMazePathFind a = new LeeMazePathFind();
		int numRows = 3;
		int numColumns = 3;
		List<List<Integer>> area = new ArrayList<List<Integer>>();
		area.add(Arrays.asList(1,0,0));
		area.add(Arrays.asList(1,0,0));
		area.add(Arrays.asList(1,9,1));
		System.out.println(a.minimumDistance(numRows, numColumns, area));
	}

}
