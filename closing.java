

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class closing {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("closing.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("closing.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));


		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<Integer,ArrayList<Integer>>();
		int n = Integer.valueOf(st.nextToken());
		int m = Integer.valueOf(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i = 0;i<m;i++){
			st = new StringTokenizer(br.readLine());
			
			int k = Integer.valueOf(st.nextToken());
			int v = Integer.valueOf(st.nextToken());
			if(!map.containsKey(k)){
				map.put(k, new ArrayList<Integer>());
			}
			map.get(k).add(v);
			if(!map.containsKey(v)){
				map.put(v, new ArrayList<Integer>());
			}
			map.get(v).add(k);
			
		}
		for(int i = 0;i<n;i++){
			arr.add(Integer.valueOf(br.readLine()));
		}
		
		Iterator<Integer> i = arr.iterator();
		while (i.hasNext()) {
			int current = i.next();
			
			if(bfs(map,arr,n)){
				pw.println("YES");
			}
			else{
				pw.println("NO");
				
			}
			
			i.remove();
			remove(map,current);
		}
		
		
		pw.flush();
		pw.close();
		
	}
	public static boolean bfs(HashMap<Integer,ArrayList<Integer>> map, ArrayList<Integer> nums, int n){
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] arr = new boolean[n];
		q.add(nums.get(0));
		while(!q.isEmpty()){
			int current = q.remove();
			
			arr[current-1] = true;
			ArrayList<Integer> val = map.get(current);
			for(int i = 0;i<val.size();i++){
				if(!arr[val.get(i)-1]){
				q.add(val.get(i));
				}
			}
		}
		for(int a:nums){
			if(!arr[a-1])return false;
		}
		return true;
	}
	public static void remove(HashMap<Integer, ArrayList<Integer>> map, int k){
		Set<Integer> s = map.keySet();
		Iterator<Integer> i = s.iterator();
		while(i.hasNext()){
			int current = i.next();
			ArrayList<Integer> values = map.get(current);
			
			if(current == k){
				i.remove();
			}else if(values.contains(k)){
				
				Iterator<Integer> l = values.iterator();
				while (l.hasNext()) {
					int c = l.next();
					if(c==k)l.remove();
				}
			}
			
		}
	}
	
}
