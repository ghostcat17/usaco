

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class crossroad {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("crossroad.in")));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("crossroad.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				
		int x = Integer.valueOf(br.readLine());
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int count = 0;
		for(int i = 0;i<x;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int id = Integer.valueOf(st.nextToken());
			int side = Integer.valueOf(st.nextToken());
			if(!map.containsKey(id)){
				map.put(id, side);
			}
			else{
				int current = map.get(id);
				if(current!=side){
					count++;
				}
				map.put(id, side);
			}
		}
		
		pw.println(count);
		pw.flush();
		pw.close();
		br.close();

	}

}
