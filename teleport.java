package usaco;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class teleport {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("teleport.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("teleport.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.valueOf(st.nextToken());
		int b = Integer.valueOf(st.nextToken());
		int x = Integer.valueOf(st.nextToken());
		int y = Integer.valueOf(st.nextToken());
		
		int count = Integer.min(Integer.min(Math.abs(y-a)+Math.abs(x-b), Math.abs(x-a)+Math.abs(y-b)), Math.abs(a-b));
		pw.println(count);
		pw.flush();
		pw.close();
		br.close();
	}
}
