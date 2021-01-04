package usaco;

import java.io.*;
import java.util.*;

public class helpcross {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		TreeSet<Integer> set = new TreeSet<Integer>();
		pair[] narr = new pair[n];
		for(int i = 0;i<c;i++){
			set.add(Integer.parseInt(br.readLine()));
		}
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			narr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int ret = 0;
		Arrays.sort(narr);
		for(int i = 0;i<n;i++){
			int chicken = 0;
			if(set.lower(narr[i].y)!=null){
			 chicken = set.lower(narr[i].y);
			}
			if(narr[i].x<=chicken){
				ret++;
				set.remove(chicken);
			}
		}
		pw.println(ret);
		pw.flush();
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
			return this.y-o.y;
		}
	}
}
