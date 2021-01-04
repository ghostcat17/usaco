package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class revegetate {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.valueOf(st.nextToken());
		int y = Integer.valueOf(st.nextToken());
		int[] visited = new int[x];
		HashMap<Integer,Integer> smap = new HashMap<Integer,Integer>();
		HashMap<Integer,Integer> dmap = new HashMap<Integer,Integer>();
		
		
		for(int i = 0;i<y;i++){
			st = new StringTokenizer(br.readLine());
			if(st.nextToken()=="S")smap.put(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			if(st.nextToken()=="D")dmap.put(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()));
			
		}
		
	}
	public static void bfs(int x, int v,int[] visited,HashMap<Integer,Integer> smap, HashMap<Integer,Integer> dmap){
		visited[x] = v;
		if(smap.get(x)==0){
			visited[x] = v;
		}
		else if(smap.get(x)==3-v){
			return;
		}
		
		
	}
}
