package usaco;
import java.util.*;
import java.io.*;
public class painting {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("painting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("painting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		pair[] arr = new pair[2*n];
		rect[] rect = new rect[n];
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			rect[i] = new rect(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));	
			arr[2*i] = new pair(rect[i].x.x,i);
			arr[2*i+1] = new pair(rect[i].x.y,i);
		}
		int ret = 0;
		Arrays.sort(arr);
		TreeSet<pair> set = new TreeSet<pair>();
		set.add(rect[arr[0].y].y);
		for(int i = 1;i<arr.length;i++){
			
			int current = arr[i].y;
			pair cp = rect[current].y;
			if(set.isEmpty()){
				set.add(cp);
				continue;
			}
			pair lp = set.lower(rect[current].y);
			if(!set.contains(cp)&&lp!=null){
				if(lp.x<cp.y){
					ret++;
					set.add(cp);
				}
			}
			else{
				ret++;
				set.remove(cp);
			}
		}
		pw.println(ret);
		pw.flush();
		pw.close();
	}
	public static class pair implements Comparable<pair>{
		int x,y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
		public String toString(){
			return x +" " + y;
		}
	}
	public static class rect{
		pair x;
		pair y;
		public rect(int x1, int y1, int x2, int y2){
			x = new pair(x1,x2);
			y = new pair(y1,y2);
		}
	}
}
