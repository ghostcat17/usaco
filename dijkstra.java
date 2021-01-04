package usaco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Set;

public class dijkstra {
	public static void main(String[] args){
		int n = 3;
		ArrayList<HashMap<Integer,Integer>> list = new ArrayList<HashMap<Integer,Integer>>();
		for(int i = 0;i<n;i++){
			list.add(i,new HashMap<Integer,Integer>());
		}
		list.get(0).put(1, 2);
		list.get(0).put(2, 3);
		list.get(1).put(2, 2);
		list.get(2).put(0, 2);
		System.out.println(list);
		int[] ret = shortestPath(0,list,n);
		System.out.println(Arrays.toString(ret));
		
		
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
		
		Arrays.fill(vertices, -1);
		vertices[src] = 0;
		open.add(src);
		
		while(!open.isEmpty()){
			int current = open.poll();
			closed[current] = true;
			HashMap<Integer,Integer> adj = map.get(current);
			                   
			Set<Integer> set = adj.keySet();
			Iterator<Integer> i = set.iterator();
			while(i.hasNext()){
				int index = i.next();
				int value = adj.get(index)+vertices[current];
				if(!closed[index]){
					if(vertices[index]>value||vertices[index]==-1){
						vertices[index] = value;
						pred[index] = current;
					}
					open.add(index);
				}	
			}
			
		}
		
		return pred;
		
		
	}
	
}
