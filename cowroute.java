package usaco;

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

public class cowroute {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		ArrayList<HashMap<Integer,Integer>> list = new ArrayList<HashMap<Integer,Integer>>();
		for(int i = 0;i<=1000;i++){
			list.add(i,new HashMap<Integer,Integer>());
		}
		
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			int cost = Integer.valueOf(st.nextToken());
			int size = Integer.valueOf(st.nextToken());
			st = new StringTokenizer(br.readLine());
			
			int[] temp = new int[size];
			
			for(int j = 0;j<size;j++){
				temp[j] = Integer.valueOf(st.nextToken());
			}
			
			for(int j = 0;j<size-1;j++){
				for(int k = j+1;k<size;k++){
					list.get(temp[j]).put(temp[k], cost);
				}
			}
		}
			
			shortestPath(a,b,list,1000,pw);
			pw.flush();
			pw.close();
		
	}
	public static int path(int[] pred, int a, int b){
		int i= b;
		int ret = 0;
		
		while(pred[i]!=-1){
			ret+=Math.abs(pred[i]-i);
			i = pred[i];
		}		
		return ret;
	}
	public static void shortestPath(int src, int b, ArrayList<HashMap<Integer,Integer>> map, int n, PrintWriter pw){
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
		int num = 0;
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
					}
					open.add(index);
					System.out.println(open);
				}	
			}
			}
		}
		
		pw.print(vertices[b]+" ");
		pw.println(path(pred, src, b));
		
		
		
	}
}
