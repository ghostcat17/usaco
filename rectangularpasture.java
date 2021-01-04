package usaco;
import java.io.*;
import java.util.*;
public class rectangularpasture {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		pair[] arr = new pair[n];
		
		for(int i = 0;i<arr.length;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int ret = 0;
		
		
	}
	
	public static class pair implements Comparable<pair>{
		int x, y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return this.x-o.x;
		}
		@Override
		public String toString(){
			return x +" "+ y;
		}
	}
}
