package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class cowdance {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int max = Integer.valueOf(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(br.readLine());
		}
		int lower = 1;
		int upper = n;
		while(upper>=lower){
			int mid = (upper+lower)/2;
			if(sim(arr,mid,max)){
				upper = mid-1;
			}
			else{
				lower = mid+1;
			}
		}
		pw.println(lower);
		pw.flush();
		pw.close();
	}
	
	public static boolean sim(int[] arr, int size, int time){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		int least = 0;
		for(int i = 0;i<arr.length;i++){
			if(q.size()==size){
				least = q.poll();
			}
			if(least+arr[i]>time)return false;
			q.add(least+arr[i]);
			
		}
		return true;
		
	}
}
