package usaco;


import java.io.*;
import java.util.*;

public class triangless {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("milkvisits.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("milkvisits.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.valueOf(br.readLine());
		pair[] arr = new pair[x]; 
		for(int i = 0;i<x;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()));
		}
		

		HashMap<Integer,HashSet<Integer>> xmap = new HashMap<Integer,HashSet<Integer>>();
 		HashMap<Integer,HashSet<Integer>> ymap = new HashMap<Integer,HashSet<Integer>>();
		for(int i = 0;i<arr.length;i++){
 			if(!xmap.containsKey(arr[i].x)){
 				xmap.put(arr[i].x, new HashSet<Integer>());
 			}
			xmap.get(arr[i].x).add(arr[i].y);
		}
 		
		for(int i = 0;i<arr.length;i++){
 			if(!ymap.containsKey(arr[i].y)){
 				ymap.put(arr[i].y, new HashSet<Integer>());
 			}
			ymap.get(arr[i].y).add(arr[i].x);
		}
 		Set<Integer> s = ymap.keySet();
 		Iterator<Integer> i = s.iterator();
 		
 		while(i.hasNext())
 		
 		
	}
	public static void first(pair[] arr){
		Arrays.sort(arr,new Comparator<pair>(){
			public int compare(pair p1, pair p2){
				return p1.x-p2.x;
			}
		});
	}
	public static void second(pair[] arr){
		Arrays.sort(arr,new Comparator<pair>(){
			public int compare(pair p1, pair p2){
				return p1.y-p2.y;
			}
		});
	}
	public static class pair{
		int x;
		int y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString(){
			return x + " " + y;
		}
	}

}
