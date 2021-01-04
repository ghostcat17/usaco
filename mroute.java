

import java.util.*;
import java.io.*;
public class mroute {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("mroute.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("mroute.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		ArrayList<List<node>> map = new ArrayList<List<node>>();

		for(int i = 0;i<n;i++){
			map.add(new ArrayList<node>());
		}
		int[] cs = new int[m];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());

			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			map.get(I-1).add(new node(J-1,L,C));
			map.get(J-1).add(new node(I-1,L,C));
			cs[i] = C;
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<m;i++){

			int current = shortestPath(0,map,n,cs[i]);
			if(current>=0){
				ans = Integer.min(ans, current+x/cs[i]);
			}
		}
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	public static int shortestPath(int src, ArrayList<List<node>> map, int n, int c){
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
			List<node> adj = map.get(current);
			for(node curr:adj){
				int index = curr.a;
				int value = curr.b+vertices[current];
				if(!closed[index]&&curr.c>=c){
					if(vertices[index]>value||vertices[index]==-1){
						vertices[index] = value;
						pred[index] = current;
					}
					open.add(index);
				}	
			}

		}

		return vertices[n-1];


	}
	public static class node{
		int a, b, c;
		public node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
