package usaco;

import java.util.*;
import java.io.*;
public class lightson {
	static int[] dx = new int[]{-1,1,0,0};
	static int[] dy = new int[]{0,0,-1,1};
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lightson.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(".out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		LinkedList<pair>[][] list = new LinkedList[n][n];
		
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(list[a-1][b-1]==null){
				list[a-1][b-1] = new LinkedList<pair>();
				
			} 
			if(list[c-1][d-1]==null){
				list[c-1][d-1] = new LinkedList<pair>();
				
			} 
			
			list[a-1][b-1].add(new pair(c-1,d-1));
			
		}
		int count = 0;
		boolean[][] arr = bfs(list);
		for(boolean[] b:arr){
			for(boolean a:b){
				if(a){
					count++;
				}
			}
		}
		pw.println(count);
		pw.flush();
		pw.close();
	}
	public static boolean[][] bfs(LinkedList<pair>[][] list){
		boolean[][] v = new boolean[list.length][list[0].length];
		boolean[][] on = new boolean[v.length][v[0].length];
		v[0][0] = true;
		int count = 0;
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		xq.add(0);
		yq.add(0);
		while(!xq.isEmpty()){
			int x = xq.remove();
			int y = yq.remove();
			System.out.println(x);
			System.out.println(y);
			count++;
			LinkedList<pair> current = list[x][y];
			
			while(!current.isEmpty()){
				
				pair p = current.poll();
				if(!on[p.a][p.b]){
					on[p.a][p.b] = true;
					if(hasVisitedNeighbor(p.a,p.b,v,on)){
						xq.add(p.a);
						yq.add(p.b);
						v[p.a][p.b] = true;
					}
				}
				
				
			for(int dir = 0; dir < dx.length; dir++) {
				
				if(x+dx[dir]==-1||y+dy[dir]==-1||x+dx[dir]==v.length||y+dy[dir]==v[0].length){
					continue;
				}
				if(on[x+dx[dir]][y+dy[dir]]||!v[x+dx[dir]][y+dy[dir]]){
					
					xq.add(x+dx[dir]);
					yq.add(y+dy[dir]);
					v[x+dx[dir]][y+dy[dir]] = true;
				}
			}
		}
		}
		return v;
		}
	public static boolean hasVisitedNeighbor(int x, int y, boolean[][] v, boolean[][] o) {
		for(int k = 0; k < dx.length; k++) {
			if(v[x + dx[k]][y + dy[k]] && o[x + dx[k]][ y + dy[k]]) {
				return true;
			}
		}
		return false;
	}

	public static class pair{
		int a;
		int b;
		public pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
}
