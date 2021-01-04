

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hps {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("hps.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("hps.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
				int n = Integer.valueOf(br.readLine());
				StringTokenizer st;
				
				
				String[][] combos = {
						{"sci","pap","roc"},
						{"pap","sci","roc"},
						{"pap","roc","sci"},
						{"roc","pap","sci"},
						{"sci","roc","pap"},
						{"roc","sci","pap"}
				};
				int[] cow1 = new int[n];
				int[] cow2 = new int[n];
				for(int i = 0;i<n;i++){
					st = new StringTokenizer(br.readLine());
					cow1[i] = Integer.valueOf(st.nextToken());
					cow2[i] = Integer.valueOf(st.nextToken());
					
				}
				
				int max = 0;
				int temp = 0;
				for(int i = 0;i<combos.length;i++){
					
					for(int j = 0;j<n;j++){
						System.out.println(combos[i][cow1[j]-1]);
						System.out.println(combos[i][cow2[j]-1]);
						if(combos[i][cow1[j]-1]=="roc"&&combos[i][cow2[j]-1]=="sci"){
							
							temp++;
						}
						else if(combos[i][cow1[j]-1]=="sci"&&combos[i][cow2[j]-1]=="pap"){
							
							temp++;
						}
						else if(combos[i][cow1[j]-1]=="pap"&&combos[i][cow2[j]-1]=="roc"){
	
	temp++;
}

					}
					System.out.println();
					if(temp>max){
						max = temp;
					}
					temp = 0;
				}
				pw.println(max);
				pw.flush();
				pw.close();
				br.close();
				
	}
}
