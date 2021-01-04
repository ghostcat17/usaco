package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class pails {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("pails.in")));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("pails.out")));
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x =Integer.valueOf(st.nextToken());
				int y =Integer.valueOf(st.nextToken());
				int z =Integer.valueOf(st.nextToken());
				int min = 0;
				if(x!=0){
			for(int i = 0;i<=z/x;i++){
				
				int temp = i*x;
				for(int j = 0;j<=z/y;j++){
					temp +=(j*y);
					if(temp>min&&temp<=z){
						
						
						min = temp; 
					}
				}
				
			}
				}
			pw.println(min);
			pw.flush();
			pw.close();
	}
}
