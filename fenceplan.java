


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class fenceplan {
	static boolean[] visited;
	static LinkedList<Integer>[] map;
	static Tuple[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("fenceplan.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("fenceplan.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		arr = new Tuple[n];



		map = new LinkedList[n];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new Tuple(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));

		}

		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(map[a]==null){
				map[a] = new LinkedList<Integer>();
				
			}
			if(map[b]==null){
				map[b] = new LinkedList<Integer>();
				
			}
			map[a].add(b);
			map[b].add(a);
			
		}
		visited = new boolean[n];
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++){
			if(!visited[i]){
				rect r = new rect(Integer.MAX_VALUE, 0, Integer.MAX_VALUE,0);
				min = Integer.min(min,area(dfs(i,r)));
				
			}
		}
		
		pw.println(min);
		pw.flush();
		pw.close();
	}
	public static int area(rect r){
		return (Math.abs(r.x2-r.x1)+Math.abs(r.y2-r.y1))*2;
	}
	public static rect dfs(int i, rect r){
		visited[i] = true;
		r.x1 = Integer.min(r.x1, arr[i].x);
		r.x2 = Integer.max(r.x2, arr[i].x);
		r.y1 = Integer.min(r.y1, arr[i].y);
		r.y2 = Integer.max(r.y2, arr[i].y);
		LinkedList<Integer> current = map[i];
		
		while(!current.isEmpty()){
			int a = current.poll();
			if(!visited[a]){
				dfs(a,r);
			}
		}
		return r;
	}
	public static class rect{
		int x1;
		int x2;
		int y1;
		int y2;
		public rect(int x1, int x2, int y1, int y2){
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
		@Override
		public String toString(){
			return x1+ " "+ x2 +" "+y1+" "+ y2; 
		}
	}
	public static class Tuple{
		int x;
		int y;
		public Tuple(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
