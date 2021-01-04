package usaco;
import java.util.*;
import java.io.*;
public class cowjump {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		line[] arr = new line[n];
		point[] ps = new point[n*2];
		
	
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			point x = new point(a,b,i);
			point y = new point(c,d,i);
			
			ps[2*i] = x;
			ps[2*i+1] = y; 
			arr[i] = new line(x,y);
			
		}
		Arrays.sort(ps);
		TreeSet<Integer> active = new TreeSet<Integer>();
		for(int i = 0;i<arr.length;i++){
			
		}
		
	}
	public static class point implements Comparable<point>{
		int x, y;
		int index;
		public point(int x, int y, int index){
			this.x = x;
			
			this.y = y;
			this.index = index;
		}
		@Override
		public int compareTo(point o) {
			
			return this.x - o.x;
		}
		@Override
		public boolean equals(Object p){
			return this.x == ((point)p).x && this.y == ((point)p).y;
		}
		
	}
	public static class line{
		point x,y;
		public line(point x, point y){
			this.x = x;
			this.y = y;
		}
	}
}
