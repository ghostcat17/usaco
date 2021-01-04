package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class paint {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("paint.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("paint.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int calc = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c = Integer.valueOf(st.nextToken());
		int d = Integer.valueOf(st.nextToken());
		
		if(a<c){
			if(b>=c){
				if(b>=d){
					pw.println(b-a);
				}
				else{
				pw.println(Math.abs(d-a));
				}
			}
			else{
				pw.println(Math.abs(b-a+d-c));
			}
		}
		else if(a==c){
			pw.println(Math.abs(Integer.max(b, d)-a));
		}
		else{
			if(d>=a){
				if(d>=b){
					pw.println(d-c);
				}
				else{
					pw.println(Math.abs(b-c));
				}
				
			}
			else{
				pw.println(Math.abs(b-a+d-c));
			}
		}
		pw.flush();
		pw.close();
		br.close();
	}
}
