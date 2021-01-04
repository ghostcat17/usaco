//package usaco;


import java.io.*;
import java.util.*;
public class countcross {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("countcross.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("countcross.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		boolean[][][] grid = new boolean[n][n][4];//represents N X N field and the adjacency. NSEW
		boolean[][] cows = new boolean[n][n];
		for(int i = 0;i<r;i++){
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int column = Integer.parseInt(st.nextToken())-1;
			int row1 = Integer.parseInt(st.nextToken())-1;
			int column1 = Integer.parseInt(st.nextToken())-1;
			if(column-column1<0){
				grid[row][column][1] = true;
				grid[row1][column1][0] = true;
			}
			if(column-column1>0){
				grid[row][column][0] = true;
				grid[row1][column1][1] = true;
			}
			if(row-row1<0){
				grid[row][column][2] = true;
				grid[row1][column1][3] = true;
				
			}
			if(row-row1>0){
				grid[row][column][3] = true;
				grid[row1][column1][2] = true;
				
			}
			
		}
		for(int i = 0;i<k;i++){
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken())-1;
			int column = Integer.parseInt(st.nextToken())-1;
			cows[row][column] = true;
		}
		
		boolean[][] visited = new boolean[n][n];
		int count = 0;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if(!visited[i][j]){
					
					
					int a = bfs(grid, cows, visited, i, j);
					if(a>0){
						arr.add(a);
					}
				}
			}
		}
		for(int i = 0;i<arr.size();i++){
			for(int j = i+1;j<arr.size();j++){
				count+= arr.get(i)*arr.get(j);
			}
		}
		
		pw.println(count);
		pw.flush();
		pw.close();
	}
	public static int bfs(boolean[][][] grid, boolean[][] cows, boolean[][] visited, int i, int j){
		int n = visited.length;
		int count = 0;
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		visited[i][j] = true;
		xq.add(i);
		yq.add(j);
		int[] dx = {0, 0 , 1, -1};

		int[] dy = {-1, 1 , 0, 0};
		while(!xq.isEmpty()){
			
			int x = xq.poll();
			int y = yq.poll();
			if(cows[x][y]){
				count++;
			}
			for(int dir = 0;dir<dx.length;dir++){
				if(x+dx[dir]==-1||y+dy[dir]==-1||x+dx[dir]==n||y+dy[dir]==n){
					continue;
				}
				if(grid[x][y][dir]==false&&!visited[x+dx[dir]][y+dy[dir]]){
					
					xq.add(x+dx[dir]);
					yq.add(y+dy[dir]);
					
					visited[x+dx[dir]][y+dy[dir]] = true;
					
				}
			}
			
		}
		
		return count;
	}
}
