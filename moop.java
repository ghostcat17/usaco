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
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class moop {
	public static void main(String[] args) throws IOException{
	//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("moop.in")));
	//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("moop.out")));
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	int n = Integer.valueOf(br.readLine());
	int[][] arr = new int[n][2];
	
	for(int i = 0;i<n;i++){
		StringTokenizer st = new StringTokenizer(br.readLine());
		
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
	 PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	 int ymin = arr[0][1];
	 int ymax = arr[0][1];
	 int i = 1;
	 int ret = 0;
	
	 
	pw.println();
	pw.close();
	}
}
