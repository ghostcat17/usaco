

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class moocast {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("moocast.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("moocast.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.valueOf(br.readLine());
		int[][] arr = new int[n][3];
		
		for(int i = 0;i<arr.length;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.valueOf(st.nextToken());
			arr[i][1] = Integer.valueOf(st.nextToken());
			arr[i][2] = Integer.valueOf(st.nextToken());
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0;i<n;i++){
			map.put(i, new ArrayList<Integer>());
			
			for(int j = 0;j<=i;j++){
				if(dist(arr[j][0], arr[j][1],arr[i][0],arr[i][1],arr[j][2])){
					map.get(j).add(i);
				}
				if(dist(arr[j][0], arr[j][1],arr[i][0],arr[i][1],arr[i][2])){
					map.get(i).add(j);
				}
			}
		}
		int max = -1;
		for(int i = 0;i<n;i++){
			max = Integer.max(total(i, map),max);
		}
		pw.println(max);
		pw.flush();
		pw.close();
		
	}
	
	public static int total(int start, HashMap<Integer,ArrayList<Integer>> map){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] used = new boolean[map.size()];
		int count = 0;
		q.add(start);
		while(!q.isEmpty()){
			int removed = q.remove();
			
			ArrayList<Integer> current = map.get(removed);
			for(int a:current){
				if(!used[a]){
					q.add(a);
					count++;
					used[a] = true;
				}
			}
		}
		return count;
	}
	public static boolean dist(int a, int b, int c, int d, int dist){
		return dist>Math.sqrt(Math.pow(Math.abs(c-a),2)+Math.pow(Math.abs(d-b), 2));
	}
	
	
}
