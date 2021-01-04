package usaco;

import java.io.*;
import java.util.*;

public class hopscotchsilver {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("race.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] arr = new int[r][c];
		for(int i = 0;i<r;i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0;j<c;j++){
				arr[i][j] = Integer.valueOf(st.nextToken());
			}
		}
		for(int[] a: arr){
			System.out.println(Arrays.toString(a));
		}
		pw.println(dp(arr));
		pw.flush();
		pw.close();
		
	}
	public static int dp(int[][] arr){
		int[][] visited = new int[arr.length][arr[0].length];
		
		visited[0][0]=1;
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr[i].length;j++){
				if(visited[i][j]<=0)continue;
				for(int k = i+1;k<arr.length;k++){
					for(int l = j+1; l<arr[k].length;l++){
						if(arr[i][j]!=arr[k][l]){
							
							visited[k][l]+=visited[i][j];
							visited[k][l]%=1000000007;
						}
					}
				}
			}
		}
		return visited[arr.length-1][arr[0].length-1];
		
	}
}
