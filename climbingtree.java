

import java.io.*;
import java.util.*;

public class climbingtree {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<arr.length;i++){
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		Long count = arr[0];
		Long max = -1L; 
		for(int i = 1;i<arr.length;i++){
			
			
			if(arr[i]-arr[i-1]<=k){
				count+=arr[i];
			}
			else{
				count = arr[i];
			}
			max = Long.max(max, count);
		}
		
		pw.println(max);
		pw.flush();
		pw.close();
	}
}
