package usaco;
import java.util.*;

import usaco.moocastgold.pair;

import java.io.*;
public class checklist {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("homework.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("homework.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int[][][] dp = new int[h][g][2];
		pair[] hol = new pair[h];
		pair[] guer = new pair[g];
		for(int i = 0;i<h;i++){
			st = new StringTokenizer(br.readLine());
			hol[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		for(int i = 0;i<g;i++){
			st = new StringTokenizer(br.readLine());
			guer[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i = 0;i<dp.length;i++){
			for(int j = 0;j<dp[i].length;j++){
				for(int k = 0;k<2;k++){
					if(k == 0 && i == 0) continue;
					if(k == 1 && j == 0) continue;
					pair src;
					src = (k==0)?hol[i-1]:guer[j-1];
					
				}
			}
		}
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
		public int dist(pair o){
			return (this.x-o.x)*(this.x-o.x)+(this.y-o.y)*(this.y-o.y);
		}
	}
}	
