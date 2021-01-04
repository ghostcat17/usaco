package usaco;

import java.io.*;
import java.util.*;

public class piggyback {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("censor.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("censor.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int b = Integer.valueOf(st.nextToken());
		int e = Integer.valueOf(st.nextToken());
		int p = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken())-1;
			int y = Integer.valueOf(st.nextToken())-1;
			if(!map.containsKey(x)){
				map.put(x, new ArrayList<Integer>());
				
			}
			if(!map.containsKey(y)){
				map.put(y, new ArrayList<Integer>());
				
			}	
			map.get(x).add(y);
			map.get(y).add(x);
		}
		//System.out.println(map);
		int[] be = new int[n];
		int[] el = new int[n];
		int[] nd = new int[n];
		bfs(0,be,map);
		//System.out.println(Arrays.toString(be));
		bfs(1,el,map);
		//System.out.println(Arrays.toString(el));
		bfs(n-1,nd, map);
		//System.out.println(Arrays.toString(nd));
		int ans = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++){
			ans = Integer.min(be[i]*b+el[i]*e+nd[i]*p, ans);
		}
		pw.println(ans);
		pw.flush();
		pw.close();
		
	}
	public static void bfs(int a, int[] visited, HashMap<Integer,ArrayList<Integer>> map){
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(a);
		
		Arrays.fill(visited, -1);
		int count = 0;
		visited[a] = count;
		while(!q.isEmpty()){
			int current = q.remove();
			
			
			ArrayList<Integer> arr = map.get(current);
			for(int i = 0;i<arr.size();i++){
				if(visited[arr.get(i)]==-1){
					visited[arr.get(i)] = visited[current]+1;
					q.add(arr.get(i));	
				}
			}
		}
	}
}
