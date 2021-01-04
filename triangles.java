

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class triangles {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("triangles.in")));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("triangles.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				StringTokenizer st;
				
			int n = Integer.valueOf(br.readLine());
			int[] x = new int[n];
			int[] y = new int[n];
			
			for(int i =0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.valueOf(st.nextToken());
			y[i] = Integer.valueOf(st.nextToken());
			
			
			}
			int max = 0;
			for(int i = 0;i<n;i++){
				int ix = x[i];
				int iy = y[i];
				
				for(int j = 0;j<n;j++){
					int jx = x[j];
					int jy = y[j];
					for(int k = 0;k<n;k++){
						int kx = x[k];
						int ky = y[k];
							if(iy!=jy||jx!=kx){
								continue;
							}
							else{
								int current = Math.abs(ix-jx)*Math.abs(jy-ky);
								max+=current;
							}
						
					}
				}
			}
			
			pw.println(max);
			pw.flush();
			pw.close();
	}

}
