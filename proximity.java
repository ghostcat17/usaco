

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class proximity {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("proximity.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("proximity.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		int max = -1;
		int[] arr = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(br.readLine());
		}
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<k;i++){
			if(map.containsKey(arr[i])){
				
				int current = map.get(arr[i]);
				if(current>0&&max<arr[i]){
					max=arr[i];
				}
				map.put(arr[i], current+1);
			}
			else{
			map.put(arr[i], 1);
			}
			}
		for(int i = k;i<arr.length;i++){
			
			if(map.containsKey(arr[i])){
		
				int current = map.get(arr[i]);
				
				if(current>0&&max<arr[i]){
					max=arr[i];
				}
				map.put(arr[i], current+1);
			}
			else{
			map.put(arr[i], 1);
			}
			map.put(arr[i-k],map.get(arr[i-k])-1);
			}
		pw.println(max);
		pw.flush();
		pw.close();
	}
}
