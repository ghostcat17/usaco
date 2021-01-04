package usaco;

import java.io.*;

import java.util.*;

public class diamond {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("diamond.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("diamond.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());

		int[] arr = new int[n];

		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.valueOf(br.readLine());
		}
		Arrays.sort(arr);
		HashMap<Integer,Integer> rmap = selectr(arr,k);
		HashMap<Integer,Integer> lmap = selectl(arr,k);
		int[] ll = new int[n];
		int[] lr = new int[n];
		ll[0] = lmap.get(0);
		for(int i = 1;i<arr.length;i++){
			ll[i] = Integer.max(lmap.get(i), ll[i-1]);
		}
		lr[n-1] = rmap.get(n-1);
		for(int i = arr.length-2;i>0;i--){
			lr[i] = Integer.max(rmap.get(i), lr[i+1]);
		}
		
		pw.println(max(ll,lr));
		
		pw.flush();
		pw.close();
	}
	public static int max(int[] ll, int[] lr){
		int max = 0;
		for(int i = 0;i<ll.length-1;i++){
			max = Integer.max(ll[i]+lr[i+1],max);
		}
		return max;
	}
	public static HashMap<Integer,Integer> selectl(int[] arr, int k){
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int l = 0;l<arr.length;l++){
			map.put(l, 0);
		}
		int j=0;
		for(int i = 0;i<arr.length;i++){
			while(j<arr.length&&arr[i]-arr[j]>k){
				j++;
				
			}
			map.put(i, i-j+1);
		}
		System.out.println(map);
		return map;
	}
public static HashMap<Integer,Integer> selectr(int[] arr, int k){
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int l = 0;l<arr.length;l++){
			map.put(l, 0);
		}
		int j=arr.length-1;
		for(int i = arr.length-1;i>=0;i--){
			while(j>=0&&arr[j]-arr[i]>k){
				j--;
				
			}
			map.put(i, j-i+1);
		}
		System.out.println(map);
		return map;
	} 
	

}
