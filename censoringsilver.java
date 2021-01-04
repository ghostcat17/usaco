package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class censoringsilver {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("race.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
  

		String in = br.readLine();
		String censor = br.readLine();

		Stack<Integer> s = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int N = in.length();
		int M = censor.length();
		int i = 0, j = 0, p = 0, t = 0, h=1;
		int q = 101;
		for (i = 0; i < M-1; i++) 
			h = (h*26)%q; 
		for (i = 0; i < M; i++){ 
			p = (26*p + in.charAt(i)-'a')%q; 
			t = (26*t + censor.charAt(i)-'a')%q; 
		} 
		
		for (i = 0; i <= N - M; i++) 
		{ 
			
			sb.append(in.charAt(i));
			s.push(t);
			
			if ( i < N-M ) 
	            { 
	                t = (26*(t - (in.charAt(i)-'a')*h) + (in.charAt(i+M)-'a'))%q; 
	      
	                // We might get negative value of t, converting it 
	                // to positive 
	                if (t < 0) 
	                t = (t + q); 
	            } 

		}
		}

	}
