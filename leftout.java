package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class leftout {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		int x = Integer.valueOf(br.readLine());
		
		boolean[][] arr = new boolean[x][x];
		
		for(int i = 0;i<arr.length;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0;j<arr.length;j++){
				String next = st.nextToken();
				if(st.nextToken()=="R"){
					arr[i][j] = true;
				}
			}
		}
		
		
		
	}
}
