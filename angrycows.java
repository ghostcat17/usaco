

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.SignedObject;
import java.util.Arrays;
import java.util.StringTokenizer;

public class angrycows {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("angry.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("angry.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.valueOf(st.nextToken());
		int cows = Integer.valueOf(st.nextToken());
		int[] hay = new int[n];
		for(int i = 0;i<n;i++){
			hay[i] = Integer.valueOf(br.readLine());
		}
		int l = 0, u = n;
		Arrays.sort(hay);
		while(l!=u){
			
			int mid = (l+u)/2;
			if(sim(hay,mid,cows)){
				u = mid;
			}
			else{
				l = mid+1;
			}
		}
		pw.println(l);
		pw.flush();
		pw.close();
	}
	public static boolean sim(int[] arr, int r, int cows){
		int last = 0;
		int used = 0;
		int n = arr.length;
		while(last < n) {
			used++;
			int curr = last+1;
			while(curr < n && arr[curr] - arr[last] <= 2*r) {
				curr++;
			}
			last = curr;
		}	
		return used<=cows;
	}
}
