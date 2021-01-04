package usaco;
import java.io.*;
import java.util.*;
public class buildgates {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("mroute.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("mroute.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		Set<pair> set = new HashSet<pair>();
		int cx = 0;
		int cy = 0;
		int count = 0;
		
		for(int i = 0;i<c.length;i++){
			if(c[i]=='N'){
				cy++;
			}
			else if(c[i]=='S'){
				cy--;
			}
			else if(c[i]=='W'){
				cx--;
			}
			else if(c[i]=='E'){
				cx++;
			}
			if(!set.contains(new pair(cx, cy))){
				set.add(new pair(cx, cy));
			}
		}
		System.out.println(set.size());
		pair[] arr = new pair[set.size()];
		set.toArray(arr);
		for(int i = 0;i<arr.length;i++){
			for(int j = i+1;j<arr.length;j++){
				pair l = arr[i];
				pair r = arr[i];
				System.out.println(l);
				System.out.println(r);
				
				if(r.x>l.x&&l.y>r.y){
					if(set.contains(new pair(l.x,r.y))&&set.contains(new pair(r.x, l.y))){
						count++;
					}
				}
			}
		}
		pw.println(count);
		pw.flush();
		pw.close();
	}
	public static class pair{
		int x;
		int y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;

		}
		@Override
		public String toString(){
			return x+" "+y;
		}
		
		@Override
		public int hashCode(){
			return x*10+y;
		}
		@Override 
		public boolean equals(Object pair){
			return this.x == ((pair)pair).x && this.y == ((pair)pair).y;
		}
	}
}
