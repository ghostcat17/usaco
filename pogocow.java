package usaco;
import java.util.*;
import java.io.*;
public class pogocow {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		pair[] arr= new pair[n];
		for(int i = 0;i<arr.length;i++){

			StringTokenizer st= new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
		}
		
		
	}
	public static class pair{
		int a;
		int b;
		public pair(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
}
