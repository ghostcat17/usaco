

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.SocketOption;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class notlast {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("notlast.in")));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("notlast.out")));
				//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
				
		int n = Integer.valueOf(br.readLine());
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int current = Integer.valueOf(st.nextToken());
			if(map.containsKey(name)){
			map.put(name,current+map.get(name));
			}
			else{
				map.put(name, current);
			}
		}
		String[] names = new String[map.size()];
		map.keySet().toArray(names);
		int[] elements = new int[names.length];
		for(int i = 0;i<elements.length;i++){
			elements[i] = map.get(names[i]);
		}
		
		int smallest = Integer.MAX_VALUE;
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 0; i < elements.length; i++) {
		   if(elements[i]<smallest){
			   smallest = elements[i];
		   }
		}
		if(names.length<7){
			smallest = 0;
		}
		for (int i = 0; i < elements.length; i++) {
			   if(elements[i]-smallest>0&&elements[i]<secondSmallest){
				   secondSmallest = elements[i];
			   }
			}
		if(secondSmallest == Integer.MAX_VALUE){
			secondSmallest = smallest;
		}

	
	int occur = 0;
	String name = "";
	for(int i = 0;i<elements.length;i++){
		if(elements[i] == secondSmallest){
			occur++;
			name = names[i];
		}
	}
	if(occur>1){
		pw.println("Tie");
	}
	else{
		pw.println(name);
	}
	pw.flush();
	pw.close();
	br.close();
}
	}
