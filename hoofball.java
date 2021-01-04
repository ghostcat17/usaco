package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hoofball {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hoofball.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("hoofball.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int x = Integer.valueOf(br.readLine());
		int[] arr = new int[x];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0;i<x;i++){
			arr[i] = Integer.valueOf(st.nextToken());

		}

		Arrays.sort(arr);
		int count = 0;
		count = sim(arr);
		pw.println(count);

		pw.flush();
		pw.close();
		br.close();


	}
	public static boolean combinationUtil(int arr[], int data[], int start, 
			int end, int index, int r) 
	{ 
		// Current combination is ready to be printed, print it 
		if (index == r) 
		{ 
			
			boolean[] used = new boolean[arr.length];
			for (int j=0; j<r; j++) {
				bfs(arr,data[j],used);
			}
				
			return used(used); 
		} 

		// replace index with all possible elements. The condition 
		// "end-i+1 >= r-index" makes sure that including one element 
		// at index will make a combination with remaining elements 
		// at remaining positions 
		for (int i=start; i<=end && end-i+1 >= r-index; i++) 
		{ 
			data[index] = arr[i]; 
			combinationUtil(arr, data, i+1, end, index+1, r); 
		} 
		return false;
	} 
	public static int sim(int[] arr){
		
		for(int i = 0;i<arr.length;i++){
			
			if(combinationUtil(arr,new int[arr.length],0,arr.length-1,0,i)){
				return 0;
			}
			
		}
		return -1;
	}
	public static void bfs(int[] arr, int a, boolean[] used){
		int current = a;
		while(!used[current]){

			used[current] = true;

			if(current-1<0){
				current = current+1;
			}
			else if(current+1>arr.length-1){
				current = current-1;
			}

			else if(arr[current]-arr[current-1]<arr[current+1]-arr[current]){
				current = current-1;
			}
			else if(arr[current]-arr[current-1]>arr[current+1]-arr[current]){
				current = current+1;
			}

		}
	}

	public static boolean used(boolean[] arr){
		for(boolean b: arr){
			if(b==false){
				return false;
			}
		}
		return true; 
	}

}
