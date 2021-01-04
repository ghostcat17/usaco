package usaco;
import java.io.*;
import java.util.*;
public class swapsilver {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("swap.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("swap.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = i+1;
		}
		int[] arrx = new int[m];


		int[] arry = new int[m];
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			arrx[i] = Integer.valueOf(st.nextToken());
			arry[i] = Integer.valueOf(st.nextToken());

		}
		int[] swaps = arr.clone();
		int[] times = new int[n];
		for(int i = 0;i<m;i++){
			swaps = reverse(swaps,arrx[i],arry[i]);
			for(int j = arrx[i]-1;j<arry[i];j++){
				times[j]++;
			}
		}
		int max = -1;
		for(int i: times){
			max = Integer.max(i, max);
		}
		//max can be aas large as 2*m
		int[][] total = new int[2*max][n];
		total[0] = arr;
		total[1] = swaps;
		for(int i = 2;i<total.length;i++){
			for(int j = 0;j<n;j++){
				total[i][j] = total[i-1][swaps[j]-1]; 
			}
		
		}
		for(int i = 0;i<n;i++){
			pw.println(total[k%(2*max)][i]);
		}

		pw.close();
	}
	public static boolean sorted(int[] arr){
		for(int i = 0;i<arr.length-1;i++){
			if(arr[i+1]<arr[i])return false;
		}
		return true;
	}
	public static int[] reverse(int[] arr, int a, int b){
		int[] ret = arr.clone();
		for(int i = a; i<=b;i++){
			ret[b-i+a-1] = arr[i-1];
		}
		return ret;
	}

}
