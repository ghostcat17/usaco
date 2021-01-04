package usaco; 

import java.io.*;
import java.util.*;

public class zootour {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] ps = new int[n+1];
		int[] pfs = new int[n+1];
		
		for(int i = 1;i<ps.length;i++){
			ps[i] += arr[i-1];
		}
		for(int i = 1;i<ps.length;i++){
			ps[i] += ps[i-1];
		}
		for(int i = 0;i<ps.length-1;i++){
			pfs[i] += arr[i];
		}
		for(int i = n-2;i>=0;i--){
			pfs[i] += pfs[i+1];
		}
		int[] ans = new int[q];
		for(int i = 0;i<q;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(a>b){
				int temp = b;
				b = a;
				a = temp;
			}
			
			int x = Math.abs(ps[b]-ps[a]);
			int y = Math.abs(ps[a]+pfs[b]);
			ans[i] = Integer.min(x, y);
			
		}
		for(int i:ans){
			pw.println(i);
		}
		pw.flush();
		pw.close();
	}
}
