package usaco;

import java.io.*;
import java.util.*;

public class censoringsilverkmp {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("censor.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("censor.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		String s = br.readLine();
		String m = br.readLine();
		int[] arr = lps(m);
		StringBuilder sb = new StringBuilder(s);
		int count = 0;
		int i = 0;
		int j = 0;
		
		while(i<sb.length()){
			if(sb.charAt(i)==m.charAt(j)){
				j++;
				i++;
			}
			if(j==m.length()){
				sb.replace(i-j, i, "");
				j = 0;
				
				i = i-(m.length()*2);
				if(i<0){
					i = 0;
				}
				
			}
			else if(i<sb.length()&&sb.charAt(i)!=m.charAt(j)){
				if(j>0){
					j = arr[j-1];
				}
				else{
					i++;
				}
			}
		}
		pw.println(sb.toString());
		pw.flush();
		pw.close();
		
		
	}
	public static int[] lps(String m){
		int[] arr = new int[m.length()];
		int i =1;
		int j = 0;
		arr[0] = 0;
		while(i<arr.length){
			if(m.charAt(i)==m.charAt(j)){
				arr[i] = ++j;
				i++;
			}
			else{
				if(j!=0){
					j = arr[j-1];
				}
				else{
					arr[i] = 0;
					i++;
				}
			}
		}
	
		return arr;
	
	}
}
