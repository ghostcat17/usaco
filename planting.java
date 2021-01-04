//package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class planting {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		
		int x = Integer.valueOf(br.readLine());
		
		int[] a = new int[x-1];
		int[] b = new int[x-1];
		for(int i = 0;i<x-1;i++){
		StringTokenizer st = new StringTokenizer(br.readLine());
		a[i] = Integer.valueOf(st.nextToken());
		b[i] = Integer.valueOf(st.nextToken());
		
		
		}
		int[] arr = new int[x];
		for(int i = 0;i<x-1;i++){
			arr[a[i]-1]++;
			arr[b[i]-1]++;
		}
		int max = 0;
		for(int i = 0;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		pw.println(max+1);
		pw.flush();
		pw.close();
	}
}
