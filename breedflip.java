

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class breedflip {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("breedflip.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("breedflip.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		String a = br.readLine();
		String b = br.readLine();
		
		int count = 0;
		int i = 0;
		int current = 0;
		while(i<n){
			if(current==0&&a.charAt(i)!=b.charAt(i)){
				count++;
				current++;
			}
			if(a.charAt(i)==b.charAt(i)){
				current=0;
			}
			else{
				current++;
				
			}
			i++;
			
		}
		pw.println(count);
		pw.flush();
		pw.close();
		
	}

}
