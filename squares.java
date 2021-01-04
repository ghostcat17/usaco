package usaco;

import java.io.*;
import java.util.*;

public class squares {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("squares.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("squares.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		pair[] x = new pair[2*n];
		pair[] rects = new pair[n];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			x[i] = new pair(a+k/2, i); 
			x[i] = new pair(a-k/2, i);
			rects[i] = new pair(a,b);
		}
		Arrays.sort(x);
		boolean found = false; 
		int ret = 0;
		TreeSet<pair> set = new TreeSet<pair>(); 
		
		for(int i = 0;i<x.length;){
			int j = 0;
			for(j = i;j<x.length;j++){
				if(set.contains(rects[x[i].y].y)){
					set.remove(rects[x[i].y].y);
					
				}
				else{
					set.add(rects[x[i].y].y);
				}
				if(rects[x[i].y].y-set.lower(rects[x[i].y].y)<k/2&&!found){
					found = true;
					
				}
			}
			i=j;
		}
		
		
		
		
		
	}
	
	public static class pair implements Comparable<pair>{
		int x, y;
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
