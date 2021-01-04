package usaco;

import java.io.*;
import java.util.*;

public class mootube {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("socdist.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("socdist.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		
		int q = Integer.valueOf(st.nextToken());
		
		ArrayList<HashMap<Integer,Integer>> list = new ArrayList<HashMap<Integer,Integer>>();
		for(int i = 0;i<n;i++){
			list.add(new HashMap<Integer,Integer>());
		}
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int c = Integer.valueOf(st.nextToken());
			list.get(a).put(b, c);
			list.get(b).put(a, c);
			
		}
	}
}
