

import java.io.*;
import java.util.*;

public class clumsy {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("clumsy.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("clumsy.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		String in = br.readLine();
		int[] arr = new int[in.length()];
		for(int i = 0;i<in.length();i++){
			if(in.charAt(i)=='('){
				arr[i] = 1;
			}
			else{
				arr[i] = -1;
			}
		}
		int current = 0;
		int count = 0;
		for(int i = 0;i<arr.length;i++){
			if(current+arr[i]<0){
				arr[i] = -arr[i];
				count++;
			}
			current+=arr[i];
		}
		current = 0;
		for(int i = arr.length-1;i>=0;i--){
			if(current-arr[i]<0){
				arr[i] = -arr[i];
				count++;
			}
			current-=arr[i];
		}
		
		
		pw.println(count);
		pw.flush();
		pw.close();
	}
}
