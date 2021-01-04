package usaco;
import java.io.*;
import java.util.*;

public class nightofthecandles {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		pair[] arr = new pair[k];
		String s = br.readLine();
		int cx1 = 0;
		int cy1 = 0;
		int cx2 = 0;
		int cy2 = 0;
		for(int i = 0;i<k;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		
		for(int c = 0;c<s.length();c++){
			if(s.charAt(c)=='S'){
				cy2++;
			}
			if(s.charAt(c)=='N'){
				cy1--;
			}
			if(s.charAt(c)=='E'){
				cx2++;
			}
			if(s.charAt(c)=='W'){
				cx2--;
			}
			int j = 0;
			int ret = 0;
			ArrayList<Integer> active = new ArrayList<Integer>();
			for(int i = 0;i<arr.length;i++){
				while(j<arr.length&&arr[j].x-arr[i].x>(cx2-cx1)){
					if(active.size()!=0)active.remove(0);
					j++;
				}
				active.add(arr[i].y);
				int cov = 0;

				Stack<pair> stack=new Stack<>(); 

				stack.push(new pair(active.get(0),active.get(0)+(cy2-cy1)));
				for(int l = 1;l<active.size();l++){
					pair top = stack.peek();  

					// if current interval is not overlapping with stack top,  
					// push it to the stack  
					if (top.y < active.get(l))  
						stack.push(new pair(active.get(l), active.get(l)+(cy2-cy1)));  

					// Otherwise update the ending time of top if ending of current  
					// interval is more  
					else if (top.y < active.get(l)+(cy2-cy1))  
					{  
						top.y = active.get(l)+(cy2-cy1);  
						stack.pop();  
						stack.push(top);  
					}  


				}
				//get total coverage
				while (!stack.isEmpty())  
				{  
					pair t = stack.pop();

					cov+=Math.abs(t.y-t.x);

				}  

				ret+=cov*(arr[j].x-arr[i].x);
			}
			pw.println(ret);
			
		
		}
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
			// TODO Auto-generated method stub
			return 0;
		}

	}
}
