package usaco;
import java.io.*;
import java.util.*;

public class bphoto {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("msched.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("msched.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for(int i = 0;i<n;i++){
			arr[i] = Integer.parseInt(br.readLine());
		}
		
	}
	public static class pair implements Comparable<pair>{
		int x, y;
		public pair(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(pair o) {
			return this.x - o.x; 
		}
	}
	public static class BIT{
		public int[] tree;
		public BIT(int n){
			tree = new int[n+5];
		}
		public void update(int index, int value){
			index++;
			while(index<tree.length){
				tree[index] += value;
				index += index & -index;
			}
		}
		public int query(int index){
			int ret = 0;
			index++;
			while(index > 0) {
				ret += tree[index];
				index -= index & -index;
			}
			return ret;
		}
	}
}
