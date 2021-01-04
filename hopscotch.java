package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hopscotch {
	
	static int ret;
	static Character[][] arr;

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("race.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("race.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.valueOf(st.nextToken());
		int y =	Integer.valueOf(st.nextToken());
		
		
		arr = new Character[x][y];
		
		for(int i = 0;i<arr.length;i++){
			String line = br.readLine();
			
			for(int j = 0;j<arr[i].length;j++){
				arr[i][j] = line.charAt(j);
				
			}
		}
		sim(0,0);
		pw.println(ret);
		pw.flush();
		pw.close();
		
	}
	public static void sim(int x, int y){
		if(x==arr.length-1&&y==arr[x].length-1){
			ret++;
			
			return;
		}
		for(int i = x+1;i<arr.length;i++){
			for(int j = y+1;j<arr[i].length;j++){
				if(arr[x][y]!=arr[i][j]){
					sim(i,j);
				}
			}
		}
		
	}
	

}
