

import java.io.*;
import java.util.*;

public class sort {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("sort.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("sort.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		
		pair[] arr = new pair[n];
		
		for(int i = 0;i<n;i++){
			arr[i] = new pair(Integer.valueOf(br.readLine()),i);
		}
		Arrays.sort(arr);
		int ret = Integer.MIN_VALUE;
		
		for(int i = 0;i<arr.length;i++){
			ret = Integer.max(arr[i].y-i, ret);
		}
		
		pw.println(ret+1);
		pw.close();
	}
	public static class pair implements Comparable<pair>{
		int x,y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
		
	}
}
