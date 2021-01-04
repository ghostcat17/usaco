
import java.io.*;
import java.util.*;
public class balancing {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("balancing.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("balancing.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		pair[] arr = new pair[n];

		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int min = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		for(int i = 0;i<arr.length;i++){
			ArrayList<pair> up = new ArrayList<pair>();
			ArrayList<pair> down = new ArrayList<pair>();
			
			for(int j = 0;j<arr.length;j++){
				if(arr[j].y>arr[i].y){
					up.add(arr[j]);
				}
				else{
					down.add(arr[j]);
				}
			}
			
			int di = 0;
			int ui = 0;
			
			while(di<down.size()&&ui<up.size()){
				int curr = Integer.min(down.get(di).x, up.get(ui).x);
				while(di < down.size() && down.get(di).x == curr) {
					di++;
				}
				while(ui < up.size() && up.get(ui).x == curr) {
					ui++;
				}
				min = Math.min(min, Math.max(Math.max(di, down.size() - di), Math.max(ui, up.size() - ui)));
			}
		}


		pw.println(min);
		pw.flush();
		pw.close();
	}
	public static class pair implements Comparable<pair>{
		int x, y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
		
	}
}
