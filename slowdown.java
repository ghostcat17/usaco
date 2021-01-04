package usaco;

import java.io.*;
import java.util.*;

public class slowdown {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> t = new PriorityQueue<Integer>();

		PriorityQueue<Integer> d = new PriorityQueue<Integer>();
		
		
		for(int i = 0;i<n;i++){
			st = new StringTokenizer(br.readLine());
			if(st.nextToken()=="T"){
				t.add(Integer.parseInt(st.nextToken()));
			}
			else{
				d.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		d.add(1000);
		double dst = 0;
		double time = 0;
		int mult = 1;
		while(!t.isEmpty()||!d.isEmpty()){
			boolean it = false;
			if(d.isEmpty()){
				it = true;
			}
			else if(!d.isEmpty() && !t.isEmpty()){
				int dnext = d.peek();
				int tnext = t.peek();
	            if (tnext-time<(dnext-dst)*mult){
	                it = true;
	            }
			}
			
			if(!it){
				
				int dnext = d.poll();
				System.out.println(dnext-dst);
				time += mult*(dnext-dst);
				dst = dnext;
				
			}
			else{
				System.out.println(true);
				int tnext = t.poll();
				dst += (tnext-time)/(mult+0.0);
				System.out.println(tnext-time+"t");
				time = tnext;
				
			}
			mult++;
		}
		 int ct = (int) time;
		    double frac = time - ct;
		    if(frac < 0.5)
		       pw.println(ct);
		    else
		       pw.println(ct+1);
		    
		    
		pw.flush();
		pw.close();
	}
}
