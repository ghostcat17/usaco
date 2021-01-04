package usaco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class race {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("race.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.valueOf(st.nextToken());
		int n = Integer.valueOf(st.nextToken());
		for(int i =0;i<n;i++){
			int current = Integer.valueOf(br.readLine());
			int count = 0;
			int distance = 0;
			int speed =0;
			while(distance<k){
				
				count++;
				if(speed<current)speed++;
				else if(distance+rest(speed,current)>k){
					speed--;
				}
				else if(distance+rest(speed,current)<k){
					speed++;
				}
				
				distance+=speed;
			}
			
			pw.println(count);
			
		}
		pw.flush();
		pw.close();
		br.close();
	}
	public static int rest(int start, int last){
		int ret = 0;
		for(int i = start;i>=last;i--){
			ret+=i;
		}
		return ret;
	}

}
