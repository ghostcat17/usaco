package usaco;
import java.io.*;
import java.util.*;
public class poker {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("poker.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("poker.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
			int x = arr[i];
			int y = k-arr[i]-1;
			if(Math.abs(y)<x){
				arr[i] = y;
			}
		}
		Long ret = 0L;
		
		int current = 0;
		for(int i = 0;i<arr.length;i++){
			ret+=Integer.max(0, arr[i]-current);
			current=arr[i];
		}
		
		pw.println(ret);
		pw.flush();
		pw.close();
	}
}
