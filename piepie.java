package usaco;

import java.io.*;
import java.util.*;

public class piepie {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int[] be = new int[2*n];
		int[] el = new int[2*n];
		TreeSet<Integer> bs = new TreeSet<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return be[o1]-be[o2];
			}
			
		});
		TreeSet<Integer> es = new TreeSet<Integer>(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return el[o1]-el[o2];
			}
			
		});
		int[] q = new int[2*n];
		int[] dist = new int[2*n];
		int len = 0;
		for(int i = 0;i<2*n;i++){
			st = new StringTokenizer(br.readLine());
			be[i] = Integer.parseInt(st.nextToken());
			el[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i<n;i++){
			if(be[i]==0){
				q[len++] = i;
				dist[i] = 1;
			}
			else{
				es.add(i);
			}
			if(el[i]==0){

				q[len++] = n+i;
				dist[n+i] = 1;
			}
			else{
				bs.add(n+i);
			}
		}
		
		
		
		
		
	}
	
}
