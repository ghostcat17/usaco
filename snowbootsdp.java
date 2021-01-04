package usaco;
import java.io.*;
import java.util.*;
public class snowbootsdp {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("snowboots.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("snowboots.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());

		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}

		int[] s = new int[b];
		int[] d = new int[b];

		for(int i = 0;i<b;i++){
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.valueOf(st.nextToken());
			d[i] = Integer.valueOf(st.nextToken());

		}
		int min = Integer.MAX_VALUE;
		boolean[][] dp = new boolean[n][b];
		dp[0][0] = true;
		for(int j = 0;j<b;j++){
			for(int i = 0;i<n;i++){
				if(s[j]<arr[i]){
					continue;
				}
				
				for(int i2 = 0;i2<i;i2++){
					if(d[j]+i2>=i&&dp[i2][j]){
						dp[i][j] = true;
					}
				}
				for(int i2 = 0;i2<b;i2++){
					if(dp[i][i2])dp[i][j] = true;
				}
				 if (i==n-1 && dp[i][j]) min = Integer.min(min, j);
			}
		}
		pw.println(min);
		pw.flush();
		pw.close();

	}
}
