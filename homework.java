//package usaco;
import java.io.*;
import java.util.*;
public class homework {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("homework.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("homework.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] test = new int[n];
		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		
		int m = Integer.MAX_VALUE;
		int current = 0;
		int[] mins = new int[n];
		for(int i = n-1;i>=0;i--){
			current+=arr[i];
			test[i] = current;
			m = Integer.min(m, arr[i]);
			
			mins[i]= m;
			
		}
		double ans = -1;
		double[] ret = new double[n];
		for(int i = n-2;i>0;i--){
			
			
			ret[i] = ((double)(test[i]-mins[i]))/((n-i-1));
		}
	
		for(int i = 0;i<arr.length;i++){
			ans = Double.max(ans, ret[i]);
		}
		for(int i = 1;i<arr.length-1;i++){
			if(ret[i]==ans){
				pw.println(i);
			}
		}
		pw.flush();
		pw.close();
		
	}
}
