package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class scodist {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("socdist.in")));
	//	PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("socdist.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		long[] a = new long[m];
		long[] b = new long[m];
		HashMap<Long,Long> map = new HashMap<Long,Long>();
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			a[i] = Long.valueOf(st.nextToken());
			b[i] = Long.valueOf(st.nextToken());
			map.put(a[i], b[i]);
		}
		Arrays.sort(a);
		for(int i = 0; i<m;i++){
			b[i] = map.get(a[i]);
		}
		
		long l = 0;
		
		long u = b[m-1];
		long ret = 0;
		while(l!=u){
			
			long mid = (l+u)/2;
			if(sim(a,b,mid,n)){
				ret = mid;
				l = mid+1;
			}
			else{
				u = mid-1;
			}
		}
		
	
		pw.println(ret);
		pw.flush();
			pw.close();
	}
	
	public static boolean sim(long[] a, long[] b, long d, int n){
		int x = 0;
		
		long curr = -1;
		for(int i = 0;i<a.length;i++){
			
			
			
			while(Long.max(curr+d,a[i])<=b[i]){
				curr=Long.max(curr+d, a[i]);
				x++;
				if(x>=n)break;
			}
		
			if(x>=n)break;
			
		}
		System.out.println(x);
		return x >= n;
	}
}
