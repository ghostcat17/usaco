package usaco;

import java.io.*;
import java.util.*;

public class cbarn {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("cbarn.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("cbarn.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.valueOf(br.readLine());
		int[] arr = new int[x];
		for(int i = 0;i<arr.length;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0;i<arr.length;i++){
			min = Integer.min(sim(arr,i), min);
			System.out.println(min);
			System.out.println();
		}
		pw.println(min);
		pw.flush();
		pw.close();
		
	}
	public static int sim(int[] nums, int src){
		int[] arr = nums.clone();
		int ret = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		System.out.println(src);
		for(int i = 0;i<arr.length;i++){
			
			System.out.println(Arrays.toString(arr));
			System.out.println(q);
			System.out.println(ret);
			int current = (src+i)%arr.length;
			if(arr[current]>=1){
				for(int j = 0;j<arr[current];j++){
				q.add(current);
				arr[current]--;
				}
			}
			
			if(arr[current]<1){
				
				if(!q.isEmpty()){
					arr[current]++;
					int d = q.poll();
				if(d<=current){
					ret+=(current-d)*(current-d);
				}
				else{
					ret+=(arr.length-d+current)*(arr.length-d+current);
				}
				}
				else{
					return Integer.MAX_VALUE;
				}
			}
			
		}
		for(int i = 0;i<arr.length;i++){
			if(arr[i]==0){
				return Integer.MAX_VALUE;
			}
		}
		System.out.println(Arrays.toString(arr));
		return ret;
	}
}
