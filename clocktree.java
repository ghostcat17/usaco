package usaco;

import java.io.*;
import java.util.*;

public class clocktree {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("milkvisits.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("milkvisits.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i = 0;i<n;i++){
			map.put(i+1,new ArrayList<Integer>());
		}
		for(int i = 0;i<n-1;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			map.get(a).add(b);
			map.get(b).add(a);
		}
		int ret = 0;
		for(int i = 0;i<arr.length;i++){
			if(dfs(map,new boolean[n],i+1,arr)==1){
				
				ret++;
			}
		}
		pw.println(ret);
		pw.flush();
		pw.close();
		
	}
	public static int dfs(HashMap<Integer,ArrayList<Integer>> map, boolean[] visited, int v, int[] arr){
		visited[v-1] = true;
		if(map.get(v).isEmpty()){
			return 12-arr[v-1];
		}
		System.out.println(arr[v-1]);
		int result = 0;
		ArrayList<Integer> current = map.get(v);
		System.out.println(current);
		for(int i = 0;i<current.size();i++){
			if(!visited[current.get(i)-1]){
				result+=dfs(map,visited, current.get(i),arr);
			}
		}
		System.out.println(result);
		System.out.println();
		return (arr[v-1] - result)-12; 
	}
	

}
