package usaco;
import java.io.*;
import java.util.*;

public class cbarn2 {
	public static void main(String[] args) throws IOException{
		// BufferedReader br = new BufferedReader(new InputStreamReader("cbarn2.in"));
		// PrintWriter pw = new PrintWriter(new OutputStreamWriter("cbarn2.out"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		int[] dp = new int[k]
	}
}
