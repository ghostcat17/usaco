package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(br.readLine());
		}
		
		int l = 0, u = n;
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		while(l!=u){
			
			int mid = (l+u)/2;
			if(sim(arr,mid,n,m,c)){
				u = mid;
			}
			else{
				l = mid+1;
			}
		}
		
		
	}
	public static boolean sim(int[] arr, int a, int n, int m, int c){
		int wagons = 1;
		int firstArrival = arr[0];
		int firstIndex = 0;
		for(int i=1;i<n;i++)
		{
			if(arr[i] - firstArrival > a || i + 1 - firstIndex > c)
			{
				wagons += 1;
				firstArrival = arr[i];
				firstIndex = i;
			}
		}
		return (wagons <= m);
	}
}
