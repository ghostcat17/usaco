

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class word {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("word.in")));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("word.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.valueOf(st.nextToken());
				int k = Integer.valueOf(st.nextToken());
				st = new StringTokenizer(br.readLine());
				String[] arr = new String[n];
				for(int i = 0;i<n;i++){
					arr[i] = st.nextToken();
				}
				int count = 0;
				StringBuilder sb = new StringBuilder();
				for(int i = 0;i<n;i++){
					System.out.println(count);
					if(arr[i].length()+count>k){
						pw.println(sb.toString().trim());
						sb = new StringBuilder();
						count = 0;
					}
					
						sb.append(arr[i]+" ");
						count +=arr[i].length();
						if(i==n-1){
							pw.println(sb.toString().trim());
						}
					
						
						
					
				}
				pw.flush();
				pw.close();
				br.close();
	}
}
