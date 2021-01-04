

import java.io.*;
import java.util.*;

public class cowcode {
	static String s;
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("cowcode.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("cowcode.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		s = st.nextToken();
		n = Integer.parseInt(st.nextToken());
		int i = s.length();
		while(i<n){
			i*=2;
		}
		pw.println(charAt(n-1,i));
		pw.flush();
		pw.close();
		
	}
	public static char charAt(int k, int total){
		 if(k<s.length()){
			 return s.charAt(k-1);
		 }
		 if(k<total/2){
			 charAt(k,total/2);
		 }
		 
		return charAt(((k-1)/2)%(total/2),total/2);
		 
	}
}
