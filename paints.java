package usaco;
import java.util.*;
import java.io.*;
public class paints {

	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("paint.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("paint.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int current = 0;
		pair[] arr = new pair[2*n];
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			
			int c = Integer.parseInt(st.nextToken());
			
			String s = st.nextToken();
			
			
			if(s.equals("R")){
				arr[i*2] = new pair(current,0);
				current+=c;
				arr[i*2+1] = new pair(current,1);
			}
			else{
				arr[i*2+1] = new pair(current,1);
				current-=c;
				arr[i*2] = new pair(current,0);
			}
			
			
			
		}
		
		Arrays.sort(arr);
		
		int ret = 0;
		int last = 0;
		int count = 0;
		for(int i = 0;i<arr.length;){
			if(count>=k){
				ret+=arr[i].x-last;
			}
			last = arr[i].x;
			int j = 0;
			for(j=i;j<arr.length&&arr[j].x==arr[i].x;j++){
				if(arr[j].y==0){
					count++;
				}
				else{
					count--;
				}
			}
			i = j;
		}
		pw.println(ret);
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
		public String toString(){
			return x +" "+ y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x-o.x;
		}
	}

}
