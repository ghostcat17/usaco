package usaco;

import java.io.*;
import java.util.*;

public class rental {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("rental.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("rental.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
	
		Integer[] arr = new Integer[n];
		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.valueOf(br.readLine());
		}
		pair[] milk = new pair[m];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			milk[i] = new pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		
		Integer[] cows = new Integer[r];
		
		for(int i = 0;i<r;i++){
			cows[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(cows, Collections.reverseOrder());
		Arrays.sort(milk, Collections.reverseOrder());
		for(int i = 1;i<cows.length;i++){
			cows[i-1]+=cows[i];
		}
		for(int i = 1;i<arr.length;i++){
			arr[i-1]+=arr[i];
		}
		int ret = Integer.MIN_VALUE;
		int i = 0;
		while(i<n){
			if(i<m-1){
				ret = Integer.max(ret, milk(arr,milk,i));
			}
			else{
				ret = Integer.max(ret, milk(arr,milk,i)+cows[n-m-1]);
			}
			i++;
		}
		pw.println(ret);
		pw.flush();
		pw.close();
	}
	public static int milk(Integer[] arr, pair[] milk, int i){
		int tm = arr[i];
		int ret = 0;
		for(int j = 0;j<milk.length;j++){
			if(tm>milk[j].x){
				ret+=(tm-milk[j].x)*milk[j].y;
				tm-=milk[j].x;
			}
			else{
				ret+=(tm)*milk[j].y;
				tm = 0;
			}
		}
		return ret;
	}
	public static class pair implements Comparable<pair>{
		int x;
		int y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			return this.y-o.y;
		}
	}
}
