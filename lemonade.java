package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class lemonade {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.valueOf(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i = 0;i<n;i++){
			arr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(arr);
		
		int i = 0;
		int j = arr.length-1;
		HashSet<Integer> set = new HashSet<Integer>();
		while(j>=i){
			if(set.size()>arr[i]){
				i++;
			}
			if(set.size()<=arr[i]){
				set.add(arr[j]);
				j--;
				
			}
			System.out.println(set.size());
		}

		pw.println(set.size());
		pw.flush();
		pw.close();
	}
}
