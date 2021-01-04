//package usaco;
import java.io.*;

import java.util.*;

public class reststops {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("reststops.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("reststops.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int l = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		
		int rf = Integer.valueOf(st.nextToken());
		int rb = Integer.valueOf(st.nextToken());
		int[] x = new int[n];
		int[] t = new int[n];
		boolean[] stop = new boolean[n];
		int max= 0;
		int ind = 0;
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.valueOf(st.nextToken());
			t[i] = Integer.valueOf(st.nextToken());
			
		}
		for(int i = n-1;i>=0;i--){
			if(t[i]>max){
				stop[i] = true;
			}
		}
		long ans = 0;
		long tf = 0;
		long tb = 0;
		int lastx = 0;
		for(int i = ind;i<n;i++){
			if(stop[i]){
				tf += (x[i] - lastx)*((long)rf);
				tb += (x[i] - lastx)*((long)rb);
				ans += (tf - tb)*((long)t[i]);
				tb = tf;
				lastx = x[i];
			}
		}
		pw.println(ans);
		pw.flush();
		pw.close();
	}
}
