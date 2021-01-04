package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class cowtip {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hps.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("hps.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		boolean[][] arr = new boolean[n][n];
		
		int[] combos = new int[n];
		for(int i = 0;i<n;i++){
			combos[i] = i;
		}
		while(!solved(arr)){
			
		}

	}
	public static boolean solved(boolean[][] arr){
		for(int i = 0;i<arr.length;i++){
			for(int j = 0;j<arr[i].length;j++){
				if(arr[i][j]==true){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean[][] solve(boolean[][] arr, int x, int y){
		boolean[][] ret = arr.clone();
		for(int i = 0;i<x;i++){
			for(int j = 0;j<y;j++){
				ret[i][j] = !ret[i][j];
			}
		}
		return ret;
	}
	
	

}
