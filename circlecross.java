package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class circlecross {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				
				
		int x = Integer.valueOf(br.readLine());
		int[] arr = new int[2*x];
		int[][] intervals = new int[x][2];
		for(int i = 0;i<2*x;i++){
			arr[i] = Integer.valueOf(br.readLine());
			if(intervals[arr[i]-1][0]==0){
				intervals[arr[i]-1][0]=i+1;
			}
			else{
				intervals[arr[i]-1][1]=i+1;
			}
		}
		int count  = 0;
		
		for(int i =0;i<x;i++){
			int a = intervals[i][0];
			int b = intervals[i][1];
			
			for(int j = i+1;j<x;j++){
				int c = intervals[j][0];
				int d = intervals[j][1];
				if(a<c&&b>c&&b<d){
					System.out.println(i+1);
					System.out.println(j+1);
					count++;
				}
				else if(a>c&&b>c&&b<d){
					System.out.println(i+1);
					System.out.println(j+1);
					count++;
				}
			}
		}
		
		
	pw.println(count);
	pw.flush();
	pw.close();
	}
	
}
