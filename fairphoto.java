package usaco;

import java.io.*;
import java.util.*;

public class fairphoto {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("homework.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("homework.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		pair[] arr = new pair[n];
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.valueOf(st.nextToken()),st.nextToken());
		}
		Arrays.sort(arr);
		int[] s = new int[n];
		int[] w = new int[n];
		int cs = 0;
		int cw = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i].s=="s"){
				cs++;
			}
			else if(arr[i].s=="w"){
				cw++;
			}
			s[i] = cs;
			w[i] = cw;
		}
		ArrayList<Integer> o = new ArrayList<Integer>();
		ArrayList<Integer> e = new ArrayList<Integer>();
		
		for(int i = 0;i<arr.length;i++){
			if(i%2==0&&w[i]>=s[i]){
				e.add(i);
				
			}
			if(i%2==1&&w[i]>=s[i]){
				o.add(i);
			}
			
		}
		int ret = -1;
		for(int i = 0;i<arr.length;i++){
			if(i%2==0){
				ret = Integer.max(find(i,arr,o),ret);
			}
			if(i%2==1){
				ret = Integer.max(find(i,arr,e),ret);
			}
			
		}
		
	}
	public static int find(int i, pair[] arr, ArrayList<Integer> c){
		int l = 0;
		int r = i;
		while(l<r){
			int m = (l+r)/2;
			if(arr[c.get(m)]<arr[i]){
				
			}
		}
		
	}
	public static class pair implements Comparable<pair>{
		int x;
		String s;
		public pair(int x, String s){
			this.x = x;
			this.s = s;
		}
		@Override
		public int compareTo(pair o) {
			return this.x - o.x;
		}
		
	}
}
