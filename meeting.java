package usaco;
import java.util.*;
import java.io.*;
public class meeting {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("meeting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("meeting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		LinkedList<pair>[] be = new LinkedList[n];

		LinkedList<pair>[] el = new LinkedList[n];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(be[a]==null){
				be[a] = new LinkedList<pair>();
			}
			be[a].add(new pair(b,c));
			if(el[a]==null){
				el[a] = new LinkedList<pair>();
			}
			el[a].add(new pair(b,d));
		}
	}
	public static int dp(int[][] dist){
		boolean[][] dp = new boolean[n][]
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
