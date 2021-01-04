package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class msched {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				
		int n = Integer.valueOf(br.readLine());
		int[] milk = new int[n];
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			milk[i] = Integer.valueOf(st.nextToken());
			map.put(milk[i], Integer.valueOf(st.nextToken()));
		}
			Arrays.sort(milk);
			Set<Integer> set = new HashSet<Integer>();
			int count = 0;
			for(int i = n-1;i>=0;i--){
				if(!set.contains(map.get(milk[i]))){
					count+=milk[i];
					set.add(map.get(milk[i]));
				}
			}
			pw.println(count);
			pw.flush();
			pw.close();
	}
}
