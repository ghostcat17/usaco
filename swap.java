package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swap {

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("swap.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("swap.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		int k = Integer.valueOf(st.nextToken());
		
		int[] arr = new int[n];
		for(int i = 0;i<arr.length;i++){
			arr[i]=i+1;
		}
		int[] arrx = new int[m];
		
		
		int[] arry = new int[m];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			arrx[i] = Integer.valueOf(st.nextToken());
			arry[i] = Integer.valueOf(st.nextToken());
			
		}
		int[] swaps = arr.clone();
		for(int i = 0;i<m;i++){
			swaps = reverse(swaps,arrx[i],arry[i]);
			
			
			}
		ArrayList<int[]> list = new ArrayList<int[]>();
		int[] current = arr.clone();
		current = sim(swaps,current);
		
		list.add(current.clone());
		while(!Arrays.equals(current, arr)){
			
		current = sim(swaps,current);
		
		list.add(current.clone());
		
		}
		for(int[] a: list){
			System.out.println(Arrays.toString(a));
		}

		if(k%list.size()>0){
		int[] ret =list.get(k%list.size()-1);
		for(int i = 0;i<ret.length;i++){
			pw.println(ret[i]);
		}}
		else{
		for(int i = 0;i<arr.length;i++){
			pw.println(arr[i]);
		}
		}
		pw.flush();
		pw.close(); 
	}
	public static int[] sim(int[] arr, int[] current){
		int[] temp = current.clone();
		
		for(int i = 0;i<current.length;i++){
			
			current[i] = temp[arr[i]-1]; 
		}
		
	return current;
		
	}
	public static int[] reverse(int[] arr, int a, int b){
		int[] ret = arr.clone();
		for(int i = a; i<=b;i++){
			ret[b-i+a-1] = arr[i-1];
		}
		return ret;
	}

}
