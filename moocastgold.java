package usaco;
import java.util.*;

import java.io.*;
public class moocastgold {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("homework.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("homework.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		pair[] arr = new pair[n];
		StringTokenizer st;
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), weight());	
		}
		LinkedList<pair>[] graph = new LinkedList[n];
		for(int i = 0;i<n;i++){
			graph[i] = new LinkedList<pair>();
		}
		int[] connect = new int[n];
		
		pw.println();
		pw.flush();
		pw.close();
	}

	public static int weight(int x1, int y1, int x2, int y2){
		return Math.abs((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
	}
	public static class pair implements Comparable<pair>{
		int x,y,z;
		public pair(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
		
	}
}
