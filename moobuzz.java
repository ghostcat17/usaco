package usaco;

import java.io.*;
public class moobuzz {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("moobuzz.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("moobuzz.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[8];
		int j = 0;
		int count = 0;
		for(int i = 0;i<15;i++){
			if((i+1)%3==0||(i+1)%5==0){
				count++;
			}
			else{
				arr[j] = count;
				j++;
			}
			
		}
		int index = (n-1)%arr.length;
		int times = n/arr.length;
	
		long ret = arr[index]+7*times+n;
		
		pw.println(ret);
		pw.flush();
		pw.close();
		
	}

}
