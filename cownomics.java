package usaco;
import java.util.*;

import usaco.buildgates.pair;

import java.io.*;
public class cownomics {
	
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("cowcode.in")));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("cowcode.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		String[] spot = new String[n];
		String[] not = new String[n];
		for(int i = 0;i<spot.length;i++){
			spot[i] = br.readLine();
		}
		for(int i = 0;i<n;i++){
			not[i] = br.readLine();
		}
		int ret = 0;
		for(int i = 0;i<m;i++){
			for(int j = 0;j<m;j++){
				for(int k = 0;k<m;k++){
					HashSet<pair> set = new HashSet<pair>();
					for(int l = 0;l<m;l++){
						
					}
				}
			}
		}
		
	}
	public static boolean test(){
		
	}
	
}
