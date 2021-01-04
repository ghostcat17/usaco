package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class cowqueue {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("race.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int x = Integer.valueOf(br.readLine());

		int current = 0;

		int[] arr = new int[x];
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<arr.length;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.valueOf(st.nextToken());
			map.put(arr[i], Integer.valueOf(st.nextToken()));
		}
		Arrays.sort(arr);
		int time = 0;
		for(int i = 0;i<x;i++){
			if(time>arr[i]){
				time+=map.get(arr[i]);
			}
			else{
				time+=arr[i]-time;
				time+=map.get(arr[i]);
			}
		}
		
		pw.println(time);
		pw.flush();
		pw.close();
		
	}
}
