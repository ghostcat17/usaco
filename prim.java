package usaco;
import java.io.*;
import java.util.*;


public class prim {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodes = 0, edges = 0, x = 0, y = 0, weight = 0, min;
		LinkedList<pair>[] arr = new LinkedList[nodes];
		nodes = Integer.parseInt(st.nextToken());
		edges = Integer.parseInt(st.nextToken());
		for(int i = 0;i<nodes;i++){
			arr[i] = new LinkedList<pair>();
		}
		for(int i = 0;i<edges;i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			arr[x].add(new pair(weight, y));

			arr[y].add(new pair(weight, x));
		}
		System.out.println(mst(arr));
	}
	public static int mst(LinkedList<pair>[] arr){
		PriorityQueue<pair> current = new PriorityQueue<pair>();
		int ret = 0;
		boolean[] v = new boolean[arr.length];
		current.add(new pair(0,0));
		while(!current.isEmpty()){
			pair x = current.poll();
			int c = x.y;
			int min = x.x;
			if(v[c])continue;
			ret+=min;
			v[c] = true;
			LinkedList<pair> l = arr[c];
			for(int i = 0;i<l.size();i++){
				int t = l.get(i).y;
				if(!v[t]){
					current.add(l.get(i));
				}
			}
		}
		return ret;
	}
	public static class pair implements Comparable<pair>{
		int x,y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
		
	}
}
