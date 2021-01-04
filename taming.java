package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class taming {

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("taming.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("taming.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.valueOf(br.readLine());
		
		int[] arr = new int[x];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0;i<x;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		int max = 0;
		int min = 0;
		int i = x-1;
		while(i>=0){
			
			int current = arr[i];
			if(current > 0){
				i-=current+1;
				min++;
				max++;
			}
			else if(current == 0){
				i--;
				min++;
				max++;
			}
			else if(current==-1){
				max++;
				i--;
				
			}
			
			
		}
		if(arr[0]==-1){
			min++;
		}
		
		pw.println(min+" "+max);
	
		pw.flush();
		pw.close();
		br.close();
	}
	
			
			
}
