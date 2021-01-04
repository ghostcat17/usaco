package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class cow {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("race.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int x = Integer.valueOf(br.readLine());
		int[] c = new int[x];
		int[] o = new int[x];
		int[] w = new int[x];
		int cn = 0;
		int on = 0;
		int wn = 0;
		int count = 0;
		String line = br.readLine();
		for(int i = 0;i<x;i++){
			if(line.charAt(i)=='C'){
				cn++;
				
			}
			if(line.charAt(i)=='O'){
				on++;
				
			}
			if(line.charAt(i)=='W'){
				wn++;
				
				
			}
			
			c[i] = cn;
			o[i] = on;
			w[i] = wn;
			if(line.charAt(i)=='W'){
				count+=c[i]*o[i];
				
				
			}
			
		}
		pw.println(count);
		pw.flush();
		pw.flush();
	}
}
