

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milkvisits {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("milkvisits.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("milkvisits.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		
		
		String let = br.readLine();
		int[] root = new int[n];
		for(int i = 0;i<root.length;i++){
			root[i] = i;
		}
		for(int i = 0;i<n-1;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken())-1;
			int b = Integer.valueOf(st.nextToken())-1;
			if(let.charAt(a)==let.charAt(b)){
				root[b] = root[a];
			}
			
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			sb.append(connected(root,Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()),st.nextToken(),let));
		}
		pw.println(sb.toString());
		pw.flush();
		pw.close();
	}
	public static int connected(int[] root, int a, int b, String type,String let){
		if(root[a-1]!=root[b-1]){
			return 1;
		}
		if(root[a-1]==root[b-1]){
			if(let.charAt(a-1)==type.charAt(0)){
				return 1;
			}
		}
		return 0;
	}
}
