 
import java.io.*;
import java.util.*;

public class tractor {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("tractor.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("tractor.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for(int i = 0;i<arr.length;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<arr.length;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		
		
		int l = -1, r = 1000000;
		while(l<=r){
			int mid = (l+r)/2;
			
			if(flood(arr,mid)*2>=n*n){
				r=mid-1;
			}
			else{
				l=mid+1;
			}
		}
		pw.println(l);
		pw.flush();
		pw.close();
	}
	public static int flood(int[][] arr, int k){
		
		int n = arr.length;
		int max = 0;
		boolean[][] visited = new boolean[arr.length][arr.length];
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr.length;j++){
				int count = 0;
				if(!visited[i][j]){
					Queue<Integer> xq = new LinkedList<Integer>();
					Queue<Integer> yq = new LinkedList<Integer>();
					
					xq.add(i);
					yq.add(j);
					visited[i][j] = true;
					while(!xq.isEmpty()){
						int x = xq.poll();
						int y = yq.poll();
						
						count++;
						for(int d = 0;d<4;d++){
							if(x+dx[d]<0||x+dx[d]>n-1||y+dy[d]<0||y+dy[d]>n-1){
								continue;
							}
							if(Math.abs(arr[x][y]-arr[x+dx[d]][y+dy[d]])<=k&&!visited[x+dx[d]][y+dy[d]]){
								xq.add(x+dx[d]);
								yq.add(y+dy[d]);
								visited[x+dx[d]][y+dy[d]] = true;
							}
							
						}
						
					}
				}
				
				
				max = Integer.max(count, max);
			}
		}
		
		
		return max;
	}
}
