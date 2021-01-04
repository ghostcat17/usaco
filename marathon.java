package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class marathon {
	static int[] x,y;
	static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("socdist.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("socdist.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		arr = new int[k+1][n];
		x= new int[n];
		y = new int[n];
		
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.valueOf(st.nextToken());
			y[i] = Integer.valueOf(st.nextToken());
			
		}
		for(int[] a:arr){
			Arrays.fill(a, Integer.MAX_VALUE);
		}
		for(int i = 0;i<=k;i++){
			for(int j = 0;j<n;j++){
				for(int l = j+1;l<n&&i+l-j-1;l++){
					
				}
			}
		}
		
		
	}
	
	public static int distBetween(int i, int j) {
	    return dist(x[i], y[i], x[j], y[j]);  
	  }

	  public static int dist(int x1, int y1, int x2, int y2) {
	    int x = x1-x2;
	    int y = y1-y2;
	    return Math.abs(x) + Math.abs(y);
	  }
}
