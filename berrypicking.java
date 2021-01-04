package usaco;

import java.io.*;
import java.util.*;
public class berrypicking {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("milkvisits.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("milkvisits.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());
		Integer[] tar = arr.clone();
		int max = 0;
		for(int i = 1;i<arr[0];i++){
			int curr = 0;
			for(int j = 0;j<arr.length;j++){
				curr+=arr[j]/i;
			}
			if(curr<k/2){
				break;
			}
			if(curr>=k){
				max = Integer.max(max, k/2*i);
				continue;
			}
			int temp = i*(curr-k/2);
			int b = i;
			Arrays.sort(tar, new Comparator<Integer>(){

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return (o1%b)-(o2%b);
				}
				
			});
			for(int j = 0;j<n&&j+curr<k;j++){
				temp+=(tar[j]%b);
			}
			
			max = Integer.max(max, temp);
		}
		pw.println(max);
		pw.flush();
		pw.close();
	}
	
	
}
