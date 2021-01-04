
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class censor {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("censor.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("censor.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		Stack<Character> s = new Stack<Character>();

		String in = br.readLine();
		String censor = br.readLine();
		for(int i = 0;i<in.length();i++){
			StringBuilder sb = new StringBuilder();
			s.push(in.charAt(i));
			if(s.size()>=censor.length()){
				for(int j = 0;j<censor.length();j++){
					sb.insert(0, s.pop());
				}
				String remain = sb.toString();
				if(!censor.equals(remain)){
					for(int j = 0;j<censor.length();j++){
						s.push(remain.charAt(j));
					}
				}
				
			}
			

		}
		
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty()){
			sb.insert(0, s.pop());
		}
		
		pw.println(sb.toString());
		pw.flush();
		pw.close();

	}

}
