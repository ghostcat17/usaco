package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class overplanting {
	public static void main(String[] args) throws NumberFormatException, IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("planting.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("planting.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));


		int n = Integer.valueOf(br.readLine());
		rect[] rects = new rect[n];
		
		for(int i = 0;i<n;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			rects[i] = new rect(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()));
		}
		//sort by first x
		 Arrays.sort(rects, new Comparator<rect>(){
			 public int compare(rect a, rect b){
				 return a.x.a-b.x.a;
			 }
		 });
		
		
		//create events arr
		int[] arr = new int[2*n];
		 for(int i = 0;i<n;i++){
			 arr[i*2] = rects[i].x.a;
			 arr[i*2+1] = rects[i].x.b;
		 }
		
		Arrays.sort(arr);
	
		//loop through events
		//only to 2*n-1 because the last one doesn't need to be calculated
		 long ret = 0;
		
		 for(int i = 0;i<2*n-1;){
			 
			 int current = arr[i];
			 //if they have the same x value skip
			 if(i != 0 && current == arr[i - 1])
				{
					i++;
					continue;
				}
		
			//find all rectangles that are in the current x
			ArrayList<Interval> active = new ArrayList<Interval>();
			for(int j = 0;j<rects.length;j++){
				if(current<rects[j].x.b&&current>=rects[j].x.a){
					active.add(new Interval(rects[j].y.b,rects[j].y.a));
					
				}
			}
			
			//find intervals of coverage
			 int cov = 0;
			 Collections.sort(active,new Comparator<Interval>(){ 
		            public int compare(Interval i1,Interval i2) 
		            { 
		                return i1.a-i2.a; 
		            } 
		        });
			int sum = 0;
			//merge the intervals
			 Stack<Interval> stack=new Stack<>(); 
			 
			 stack.push(active.get(0));
			 for(int j = 1;j<active.size();j++){
				 Interval top = stack.peek();  
				    
		            // if current interval is not overlapping with stack top,  
		            // push it to the stack  
		            if (top.b < active.get(j).a)  
		                stack.push(active.get(j));  
		    
		            // Otherwise update the ending time of top if ending of current  
		            // interval is more  
		            else if (top.b < active.get(j).b)  
		            {  
		                top.b = active.get(j).b;  
		                stack.pop();  
		                stack.push(top);  
		            }  
		            
				 
			 }
			 //get total coverage
			 while (!stack.isEmpty())  
	            {  
	                Interval t = stack.pop();
	               
	                cov+=Math.abs(t.b-t.a);
	                
	                
	            }  
			//find next x value that is not the same as current
			 	int j = i + 1;
				while(j<n*2&&arr[j] == arr[i]){
					j++;
				}
				
				if(j<n*2){
					ret += cov * (arr[j] - current);
					
				}
				
				i = j;
				
				
		 }
		 pw.println(ret);
		 pw.flush();
		 pw.close();
	}

	public static class Interval{
		int a;
		int b;
		public Interval(int a, int b){
			this.a = a;
			this.b = b;
		}
	}
	
	public static class rect{
		Interval x;
		Interval y;
		
		public rect(int x1, int y1, int x2, int y2){
			x = new Interval(x1,x2);
			y = new Interval(y1,y2);
		}
		
	}
}
