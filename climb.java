package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class climb {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("snowboots.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("snowboots.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		int[] up = new int[n];
		int[] down = new int[n];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			up[i] = Integer.valueOf(st.nextToken());
			down[i] = Integer.valueOf(st.nextToken());
			map.put(up[i], down[i]);
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		int count = 0;
		for(int i = 0;i<up.length;i++){
			q.add(up[i]);
		}
		PriorityQueue<Integer> d = new PriorityQueue<Integer>();
		int current = 0;
		int last  = 0;
		while(!q.isEmpty()){
			current = q.remove();
			
			
		}
		
		
	}
}
