package usaco;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class relocate {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());

		ArrayList<HashMap<Integer,Integer>> list = new ArrayList<HashMap<Integer,Integer>>();

		int[] arr = new int[k];

		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.valueOf(br.readLine());
		}
		for(int i = 0;i<n+1;i++){
			list.add(new HashMap<Integer,Integer>());
		}
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());

			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int l = Integer.valueOf(st.nextToken());

			list.get(a).put(b, l);
			list.get(b).put(a, l);
		}
		HashMap<Integer,int[]> vertices = new HashMap<Integer,int[]>();


		for(int a:arr){
			
			vertices.put(a,shortestPath(a,list,n+1));
			
		}
		
		HashMap<ArrayList<Integer>,Integer> map = path(arr,vertices);
		
		
		Set<ArrayList<Integer>> set = map.keySet();
		Iterator<ArrayList<Integer>> i = set.iterator();
		int ret = Integer.MAX_VALUE;
		while(i.hasNext()){
			ArrayList<Integer> current = i.next();
			int dist = map.get(current);
			
			int[] sv = vertices.get(current.get(0));
			int[] ev = vertices.get(current.get(current.size()-1));
			
			int temp = Integer.MAX_VALUE;
			for(int j = 1;j<n+1;j++){
				if(ev[j]+sv[j]<temp&&!contains(j,arr)){
					
					temp = ev[j]+sv[j]; 
				}
			}
			
			if(ret>temp+dist){
				
				ret = dist+temp;
			}
			
		}
 		
		pw.println(ret);
		pw.flush();
		pw.close();
	}
	public static boolean contains(int a, int[] arr){
		for(int i:arr){
			if(i==a){
				return true;
			}
		}
		return false;
	}
	public static HashMap<ArrayList<Integer>,Integer> path(int[] temp, HashMap<Integer,int[]> vertices){
		ArrayList<ArrayList<Integer>> permutations = permute(temp);
		HashMap<ArrayList<Integer>,Integer> ret = new HashMap<ArrayList<Integer>,Integer>();
		for(ArrayList<Integer> a:permutations){
			ret.put(a, Integer.MAX_VALUE);
		}
		for(int i = 0;i<permutations.size();i++){
			
			ArrayList<Integer> currp = permutations.get(i);
			int dist = 0;
			
			for(int j = 0;j<currp.size()-1;j++){
				
				int[] current = vertices.get(currp.get(j));
				
				dist+=current[currp.get(j+1)];
				
			}
			ret.put(permutations.get(i), dist);
			
		}
		return ret;
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] arr) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		permuteHelper(list, new ArrayList<Integer>(), arr);
		return list;
	}

	private static void permuteHelper(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> resultList, int [] arr){

		// Base case
		if(resultList.size() == arr.length){
			list.add(new ArrayList<>(resultList));
		} 
		else{
			for(int i = 0; i < arr.length; i++){ 

				if(resultList.contains(arr[i])) 
				{
					// If element already exists in the list then skip
					continue; 
				}
				// Choose element
				resultList.add(arr[i]);
				// Explore
				permuteHelper(list, resultList, arr);
				// Unchoose element
				resultList.remove(resultList.size() - 1);
			}
		}
	} 


	public static int[] shortestPath(int src, ArrayList<HashMap<Integer,Integer>> map, int n){
		int[] vertices = new int[n];
		int[] pred = new int[n];
		boolean[] closed = new boolean[n];
		PriorityQueue<Integer> open = new PriorityQueue<Integer>(n, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return vertices[a]-vertices[b];
			}
		});	
		Arrays.fill(pred, -1);
		Arrays.fill(vertices, -1);
		vertices[src] = 0;
		open.add(src);
		
		while(!open.isEmpty()){
			
			int current = open.poll();
			
			closed[current] = true;

			HashMap<Integer,Integer> adj = map.get(current);
			if(!map.isEmpty()){
				Set<Integer> set = adj.keySet();
				Iterator<Integer> i = set.iterator();
				while(i.hasNext()){
					int index = i.next();
					int value = adj.get(index)+vertices[current];
					if(!closed[index]){
						if(vertices[index]>value||vertices[index]==-1){
							vertices[index] = value;
							pred[index] = current;
							open.add(index);
						}
					}	
				}
			}
		}

		return vertices;
	}
}
