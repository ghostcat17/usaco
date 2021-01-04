

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class speeding {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("speeding.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("speeding.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[100];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.valueOf(st.nextToken());
		int y = Integer.valueOf(st.nextToken());
		int current = 0;
		for(int i = 0;i<x;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			for(int j = current;j<a+current;j++){
				arr[j] = b;
				
			}
			current+=a;
		}
		current = 0;
		int max = 0;
		for(int i = 0;i<y;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.valueOf(st.nextToken());
			int b = Integer.valueOf(st.nextToken());
			for(int j = current;j<a+current;j++){
				System.out.println(current);
				if(b-arr[j]>max)max = b-arr[j];
			}
			current+=a;
		}
		pw.println(max);
		pw.flush();
		pw.close();
		br.close();
	
	}
}
