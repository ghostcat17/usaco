package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class cowherding {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				int x = Integer.valueOf(br.readLine());
				
				int[] arr = new int[x];
				
				for(int i = 0;i<arr.length;i++){
					arr[i] = Integer.valueOf(br.readLine());
				}
				
				Arrays.sort(arr);
				int min = -1;
				for(int i = 0;i<arr.length-1;i++){
					int count = 0;
					for(int j = i;j<arr.length-1;j++){
						if(arr[j]-arr[i]<=x){
							count++;
							
						}
					}
					if(count>min){
						min = count;
					}
				}
				
				int max = Integer.max(arr[x-2]-arr[0], arr[x-1]-arr[1]) - (x-2);
				pw.println(x-min);
				pw.println(max);
				pw.flush();
				pw.close();
				
	}
}
