package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class crowded {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(st.nextToken());
			
			int d = Integer.valueOf(st.nextToken());
		
			int ret = 0;
			int[][] arr = new int[n][2];
			for(int i = 0;i<n;i++){
				st = new StringTokenizer(br.readLine());
				
				arr[i][0] = Integer.valueOf(st.nextToken());
				
				arr[i][1] = Integer.valueOf(st.nextToken());
				
			}

			 Arrays.sort(arr, new Comparator<int[]>() {
		         @Override
		         public int compare(final int[] entry1, final int[] entry2) {
		             final int time1 = entry1[0];
		             final int time2 = entry2[0];
		             return Integer.compare(time1, time2);
		         }
		     });
			 PriorityQueue<Integer> lq = new PriorityQueue<Integer>(d,Collections.reverseOrder());
			 PriorityQueue<Integer> rq = new PriorityQueue<Integer>(d,Collections.reverseOrder());
			
			 
			 int a1 = 0; int b2 = 0;
			 for(int i = 0;i<arr.length;i++){
				
				 //leftqueue remove
				
				 while(arr[a1][0]+d<arr[i][0]&&!lq.isEmpty()){
					 
					 lq.remove(arr[a1][1]);
					 a1++;
				 }
					 
				//leftqueue insert
				lq.add(arr[i][1]);
				 //right queue insert
				 while(b2<n&&arr[b2][0]<=arr[i][0]+d){
					 rq.add(arr[b2][1]);
					 b2++;
				 }
				 if(!rq.isEmpty()){
						rq.remove(arr[i][1]);
						
					}
				
				if(!lq.isEmpty()&&!rq.isEmpty()&&lq.peek()>=2*arr[i][1]&&rq.peek()>=2*arr[i][1]){
					ret++;
				}
				 //rightqueue remove
				
			 }
			 pw.println(ret);
			 pw.flush();
			 pw.close();
	}
}