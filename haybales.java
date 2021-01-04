package usaco;

import java.io.*;
import java.util.*;

public class haybales {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("haybales.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("haybales.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		for(int i = 0;i<q;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			int a = binarySearch(Integer.min(arr[arr.length-1], x-1), arr);
			int b = binarySearch(Integer.min(arr[arr.length-1], y), arr);
			
				pw.println(b-a);
			
		}
		
		pw.flush();
		pw.close();
	}
	public static int binarySearch(int x, int[] arr){
		if(x>arr[arr.length-1]){
			return 0;
		}
		int upper = arr.length-1;
		int lower = 0;
		int ret = 0;
		
		while(upper>=lower){
			int mid = (upper+lower)/2;
			if(arr[mid]==x){
				return mid+1;
			}
			if(arr[mid]>x){
				upper = mid-1;
			}
			if(arr[mid]<x){
				lower = mid+1;
			}
		}
		return lower;
		
	}
}
