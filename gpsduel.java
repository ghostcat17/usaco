package usaco;
import java.util.*;
import java.io.*;
public class gpsduel {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("meeting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("meeting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<HashMap<Integer,Integer>> el = new ArrayList<HashMap<Integer,Integer>>();
		ArrayList<HashMap<Integer,Integer>> be = new ArrayList<HashMap<Integer,Integer>>();
		ArrayList<HashMap<Integer,Integer>> fin = new ArrayList<HashMap<Integer,Integer>>();
		for(int i = 0;i<n;i++){
			el.add(i,new HashMap<Integer,Integer>());
			be.add(i,new HashMap<Integer,Integer>());
			fin.add(i,new HashMap<Integer,Integer>());
		}
		
		
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			el.get(a-1).put(b-1, p);

			be.get(a-1).put(b-1, q);
			fin.get(a-1).put(b-1, 0);
		}
		int[] elarr = shortestPath(0,el,n);
		
		int[] bearr = shortestPath(0,be,n);
		
		int[] total = new int[n];
		
		for (int cur = 0; cur < n; cur++) {
			Iterator<Integer> e = el.get(cur).keySet().iterator();
			while(!e.hasNext()){
				int nxt = e.next();
				int c = 0;
				int dst1 = el.get(cur).get(e), dst2 = be.get(cur).get(e);
				if (elarr[nxt] - elarr[cur] != dst1) c++;
				if (bearr[nxt] - bearr[cur] != dst2) c++;
				total[cur] = c;
			}
		}
		
		
		
		for(int i = 0;i<n;i++){
			Iterator<Integer> f = fin.get(n).keySet().iterator();
			while(!f.hasNext()){
				int current = f.next();
				fin.get(i).put(current,total[current]);
			}
			
		}
		int[] ret = shortestPath(0,fin,n);
		pw.println(ret[n-1]);
		pw.flush();
		pw.close();
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
		
		return vertices;
		
		
	}
}
