package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class multimoo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("snowboots.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("snowboots.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		int[][] arr = new int[n][n];
		HashMap<Integer, Integer> size = new HashMap<Integer,Integer>();
		HashMap<Integer, ArrayList<Integer>> border = new HashMap<Integer, ArrayList<Integer>>();
		
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0;j<n;j++){
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		boolean[][] visited = new boolean[n][n];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<n;j++){
				if(!visited[i][j]){
				size.put(arr[i][j], bfs(arr,i,j,visited,n));
				}
				}
		}
		
		
		
		
 	
	}
	public static int bfs(int[][] arr, int i, int j, boolean[][] visited, int n){
		LinkedList<Integer> xq = new LinkedList<Integer>();
		LinkedList<Integer> yq = new LinkedList<Integer>();
		int[] dx = {-1,0,1,0};//RDLU
		int[] dy = {0,1,0,-1};//RDLU
		int count = 0;
		if(!visited[i][j]){
			count++;
			xq.add(i);
			yq.add(j);
			while(!xq.isEmpty()){
				int x = xq.remove();
				int y = yq.remove();
				for(int dir = 0;dir<4;dir++){
					
					if(x+dx[dir]==-1||y+dy[dir]==-1||x+dx[dir]==n||y+dy[dir]==n){
						continue;
					}
					if(!visited[x+dx[dir]][y+dy[dir]]&&arr[x+dx[dir]][y+dy[dir]]==arr[i][j]){
						
						xq.add(x+dx[dir]);
						yq.add(y+dy[dir]);
						
						visited[x+dx[dir]][y+dy[dir]] = true;
					}
					else{
						continue;
					}
				}
				
			}
		}
			return count;
	
	}
}
