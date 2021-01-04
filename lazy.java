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
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class lazy {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("lazy.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("lazy.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int sum = 0;
		int max = -1;
		int[] arr = new int[n];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			arr[i] = a;
			map.put(a, b);
		}
		Arrays.sort(arr);
		for(int i = 0;i<2*k||i<arr[arr.length-1];i++){
			if(map.containsKey(i)){
				sum+=map.get(i);
			}
			
		}
		max = sum;
		for(int i = 2*k;i<arr[arr.length-1];i++){
			if(map.containsKey(i)){
				sum+=map.get(i);
			}
			if(map.containsKey(i-2*k)){
				sum-=map.get(i-2*k);
			}
			if(sum>max){
				max = sum;
			}
		}
		pw.println(max);
		pw.flush();
		pw.close();
	}
}
