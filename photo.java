

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class photo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("photo.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("photo.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for(int i =0;i<n-1;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		outerloop:
		for(int i =1;i<=arr[0]-1&&i<=n;i++){
			boolean[] marked = new boolean[n+1];
			marked[i] = true;
			nums[0] = i;
			for(int j = 1;j<n;j++){
						
				System.out.println(arr[j-1]);
				System.out.println(nums[j-1]);
				System.out.println();
				int current = arr[j-1]-nums[j-1];
				if(current<0||current>n||marked[current])break;
				else{
					marked[current] = true;
					nums[j] = current;
				}
				
				
				if(j==n-1){
					StringBuilder sb = new StringBuilder();
					for(int k = 0;k<n;k++){
						sb.append(nums[k]+" ");
						
					}
					pw.println(sb.toString().trim());
					break outerloop;
				}
			}
			
			
			
		}
		pw.flush();
		pw.close();
		br.close();
	}
}
