package usaco;
import java.io.*;
import java.util.*;
public class stampede {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("stampede.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("stampede.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		cow[] arr = new cow[n*2];
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());//time reached
			int y = Integer.parseInt(st.nextToken());//time crossed
			int r = Integer.parseInt(st.nextToken());
			int a = (0-x-1)*r;
			int b = a+r;
			
			arr[i*2] = new cow(a,y, 0);

			arr[i*2+1] = new cow(b,y, 1);
		}
		
		Arrays.sort(arr);
		
		
		
		TreeSet<Integer> active = new TreeSet<Integer>();
		TreeSet<Integer> visited = new TreeSet<Integer>();
		int i = 0;
		int j = 0;
		for(i = 0;i<arr.length;){
			for(j = i;j<arr.length&&arr[i].x==arr[j].x;j++){
				
				if(arr[j].z==0){
					active.add(arr[j].y);					
				}
				else if(arr[j].z==1){
					active.remove(arr[j].y);
				}
			}
			
			if(!active.isEmpty()){
				visited.add(active.first());
			}
			i=j;
		}
		
		pw.println(visited.size());
		pw.flush();
		pw.close();
	}
	public static class cow implements Comparable<cow>{
		int x, y, z;
		public cow(int x,int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public int compareTo(cow o) {
			
			return this.x-o.x;
		}
		@Override
		public String toString(){
			return x+" "+y+" "+z;
		}
	}
}
