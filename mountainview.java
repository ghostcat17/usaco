package usaco;
import java.io.*;
import java.util.*;
public class mountainview {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("censor.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("censor.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		pair[] arr = new pair[n];
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.valueOf(st.nextToken());
			int y = Integer.valueOf(st.nextToken());
			arr[i] = new pair(x-y,x+y);
		}

		Arrays.sort(arr);
		int count = 0;
		int max = Integer.MIN_VALUE;

		for(int i = 0;i<arr.length;i++){

			if(arr[i].x2>max){
				count = 1;

			}
			else{
				count++;
			}
			max = Integer.max(arr[i].x2, max);

		}

		System.out.println(count);
	}
	public static class pair implements Comparable<pair>{
		int x1;
		int x2;

		public pair(int x1, int x2){
			this.x1= x1;
			this.x2 = x2;

		}

		@Override
		public int compareTo(pair o) {
			return this.x1-o.x1;

		}

	}
}
