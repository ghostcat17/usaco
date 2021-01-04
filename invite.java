package usaco;

import java.io.*;
import java.util.*;

public class invite {

	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("squares.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("squares.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int g = Integer.parseInt(st.nextToken());
		
		boolean[] arr = new boolean[n];
		ArrayList<ArrayList<Integer>> cow = new ArrayList<ArrayList<Integer>>();
		ArrayList<HashSet<Integer>> groups = new ArrayList<HashSet<Integer>>();
		for(int i = 0;i<n;i++){
			cow.add(new ArrayList<Integer>());
		}
		for(int i = 0;i<g;i++){
			st = new StringTokenizer(br.readLine());
			
			int current = Integer.parseInt(st.nextToken());
			groups.add(new HashSet<Integer>());
			for(int j = 0;j<current;j++){
				int a = Integer.valueOf(st.nextToken())-1;
				groups.get(i).add(a);
				cow.get(a).add(i);
				
			}
			
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		arr[0]=true;
		int ret = 1;
		while(!q.isEmpty()){
			int current = q.poll();
			ret++;
			for(int i = 0;i<cow.get(current).size();i++){
				groups.get(i).remove(current);
			}
			for(int i = 0;i<groups.size();i++){
				if(groups.get(i).size()==1){
					System.out.println(true);
					Iterator<Integer> it = groups.get(i).iterator();
					int a = it.next();
					if(!arr[a]){arr[a] = true;
					q.add(a);
					}
				}
			}
		}
		
		
	pw.println(ret);
	pw.flush();
	pw.close();
	}
	
	
}
