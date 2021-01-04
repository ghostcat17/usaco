package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class paintbarn {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("snowboots.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("snowboots.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		int[][] arr = new int[1001][1001];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			int d = Integer.valueOf(st.nextToken());
			for(int j = a;j<c;j++){
				arr[j][b]++;
				arr[j][d]--;
				
			}
		}
		int count = 0;
		
		for(int i = 0;i<arr.length;i++){
			int current = 0;
			for(int j = 0;j<arr.length;j++){
				if(current == k)count++;
				current+=arr[i][j];
			}
		}
	
		pw.println(count);
		pw.flush();
		pw.close();
		
	}
}
