package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class snowboots {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("snowboots.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("snowboots.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}

		int[] s = new int[b];
		int[] d = new int[b];


		for(int i = 0;i<b;i++){
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.valueOf(st.nextToken());
			d[i] = Integer.valueOf(st.nextToken());

		}

		pw.println(possible(arr, b, s, d));
		pw.flush();
		pw.close();
	}
	
	

	public static int iterative(int[] arr, int b, int[] s, int[] d){
		int bt = 0;
		int i = 0;
		Stack<boot> st = new Stack<boot>();
		boolean[][] visited = new boolean[b][arr.length];//boot, location
		st.push(new boot(bt,i));
		int best = Integer.MAX_VALUE;
		while(!st.isEmpty()){
			boot current = st.pop();
			System.out.println(current.x);
			System.out.println(current.y);
			System.out.println(st.size());
			System.out.println();
			if(current.y==arr.length-1){

				best = Integer.min(current.x, best);
			}
			if(visited[current.x][current.y]){
				System.out.println(true);
				continue;
			}
			visited[current.x][current.y] = true;

			for (int i2=current.y+1; i2<arr.length&& i2-current.y<=d[current.x]; i2++){ 
				if (arr[i2]<=s[current.x]) st.push(new boot(i2,current.x));
				System.out.println("forloop1");
			}
			// try all possible changes of boots
			for (int b2=current.x+1; b2<b; b2++){ 
				if (arr[i]<=s[b2]) st.push(new boot(i,b2));
				System.out.println("forloop2");
			}
		}
		return best;
	}
	public static int possible(int[] arr, int b,int[] s, int[] d){
		boolean[][] reached = new boolean[b][arr.length];
		
		for(int i = 0;i<b;i++){
			for(int j = 0;j<arr.length;j++){
				if(arr[j]>d[i]){
					reached[i][j] = false;
				}
				if(i==0&&j==0){
					reached[i][j] = true;
				}
				for(int k = 0;k<j;k++){
					if(reached[i][k]&&k+d[i]>=i){
						reached[b][j] = true;
					}
				}
				for(int k = 0;k<b;k++){
					if(reached[k][j])reached[i][j] = true; 
				}
				if(i==arr.length-1&&reached[i][j]){
					return i;
				}


			}
		}
		return -1;



	}
	public static class boot{
		int x;
		int y;
		public boot(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}