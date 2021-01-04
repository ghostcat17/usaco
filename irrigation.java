package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class irrigation {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, c, x = 0, y = 0, weight = 0, min;
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		pair[] pairs = new pair[n];
		LinkedList<pair>[] arr = new LinkedList[n];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[i] = new LinkedList<pair>();
			pairs[i] = new pair(x,y);
		}
		System.out.println(Arrays.toString(pairs));
		for(int i = 0;i<n;i++){
			for(int j = i;j<n;j++){
				if(i!=j){
					arr[i].add(new pair(dist(pairs[i].x,pairs[i].y,pairs[j].x,pairs[j].y),j));
					arr[j].add(new pair(dist(pairs[i].x,pairs[i].y,pairs[j].x,pairs[j].y),i));
				}
			}
		}
		
		pw.println(mst(arr,c));
		pw.flush();
		pw.close();
	}
	public static int dist(int x1, int y1, int x2, int y2){
		return (int)(Math.pow(x2-x1,2)+ Math.pow(y2-y1,2));
	}
	public static int mst(LinkedList<pair>[] arr, int p){
		PriorityQueue<pair> current = new PriorityQueue<pair>();
		int ret = 0;
		boolean[] v = new boolean[arr.length];
		current.add(new pair(0,0));
		while(!current.isEmpty()){
			
			pair x = current.poll();
			int c = x.y;
			int min = x.x;
			if(v[c])continue;
			ret+=min;
			v[c] = true;
			LinkedList<pair> l = arr[c];
			for(int i = 0;i<l.size();i++){
				int t = l.get(i).y;
				if(!v[t]&&l.get(i).x>=p){
					current.add(l.get(i));
				}
			}
		}
		return ret;
	}
	public static class pair implements Comparable<pair>{
		int x,y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return x+" "+y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
		
	}
}
