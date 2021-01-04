package usaco;

import java.io.*;
import java.util.*;

public class wormsort {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("milkvisits.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("milkvisits.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		HashMap<Integer, ArrayList<hole>> map = new HashMap<Integer,ArrayList<hole>>();
		for(int i = 0;i<arr.length;i++){
			map.put(i+1, new ArrayList<hole>());
		}
		int width = Integer.MIN_VALUE;
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			int w = Integer.valueOf(st.nextToken());
			map.get(a).add(new hole(b,w));
			map.get(b).add(new hole(a,w));
			if(width<w){
				width = w;
				
			}
		}
		System.out.println(map);
		int l = 0;
		int r = width;
		ArrayList<Integer> tbs = new ArrayList<Integer>();
		
		for(int i = 0;i<arr.length;i++){
			if(arr[i]!=i+1)tbs.add(i+1);
		}
		System.out.println(tbs);
		while(l!=r){
			int mid = (l+r+1)/2;
			System.out.println(mid);
			if(valid(mid, map, n, tbs)){
				System.out.println(true);
				 l = mid;
			}
			else{
				r = mid-1;
			}
		}
		pw.println(l);
		pw.flush();
		pw.close();
	}
	public static boolean valid(int w, HashMap<Integer,ArrayList<hole>> map, int n, ArrayList<Integer> tbs){
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++){
			arr[i] = i+1;
		}
		System.out.println(tbs);
		for(int i = 0;i<tbs.size();i++){
			ArrayList<hole> current = map.get(tbs.get(i));
			for(hole h:current){
				if(h.y>=w){
					arr[h.x-1] = arr[tbs.get(i)-1];
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(tbs);
		int c = arr[tbs.get(0)-1];
		for(int i = 0;i<tbs.size();i++){
			if(arr[tbs.get(i)-1]!=c){
				return false;
			}
		}
		return true;
	}
	public static class hole{
		int x, y;
		public hole(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString(){
			return x+" "+y;
		}
	}
}
