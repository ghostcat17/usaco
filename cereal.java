

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class cereal {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("cereal.in")));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("cereal.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));


				StringTokenizer st = new StringTokenizer(br.readLine());
				
				
			int n = Integer.valueOf(st.nextToken());
			int m = Integer.valueOf(st.nextToken());
			
		
			int[] x = new int[n];
			int[] y = new int[n];
			
			for(int i = 0;i<n;i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.valueOf(st.nextToken());
				int b = Integer.valueOf(st.nextToken());
				x[i] = a;
				y[i] = b;
				
				}
			int ret = 0;
			int[] cer = new int[m];
			
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i = n-1;i>=0;i--){
				int j = i;
				int curr = x[i];
				while(true){
				
				if(cer[x[i]]==0){
					
					ret++;
					cer[curr]=i;
					break;
				}
				
				else if(cer[curr]!=0||cer[curr]>j){
					int temp = cer[curr];
					cer[curr] = j;
					if(curr == y[temp])
						break;
					j = temp;
					curr = y[temp];
					
				}
				else{
					break;
				}
				}
				stack.push(ret);
			}
			while(stack.size()>0){
				pw.println(stack.pop());
			}
			pw.flush();
			pw.close();
	}
}
