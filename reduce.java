package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class reduce {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.valueOf(br.readLine());
		pair[] arr = new pair[n];
		for(int i = 0;i<arr.length;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new pair(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()));
		}

		pw.println(solve(arr));
		pw.flush();
		pw.close();
	}
	public static int solve(pair[] arr){
		int min = Integer.MAX_VALUE;
		System.out.println(Arrays.toString(arr));
		first(arr);
		pair[] sx = new pair[4];
		pair[] lx = new pair[4];
		pair[] sy = new pair[4];
		pair[] ly = new pair[4];
		for(int i = 0;i<4;i++){
			sx[i] = arr[i];
			lx[i] = arr[arr.length-i-1];
		}
		
		second(arr);
		for(int i = 0;i<4;i++){
			sy[i] = arr[i];
			ly[i] = arr[arr.length-i-1];
		}
		System.out.println(Arrays.toString(sx));
		System.out.println(Arrays.toString(sy));
		System.out.println(Arrays.toString(lx));
	
		System.out.println(Arrays.toString(ly));
		for(int i = 0;i<sx.length;i++){
			for(int j = 0;j<lx.length;j++){
				for(int k = 0;k<sy.length;k++){
					for(int l = 0;l<ly.length;l++){
						
						if(sx[i]!=lx[j]&&sy[k]!=ly[l]){
							int count = 0;
//							
						
							if(count<=3){
							min = Integer.min(area(sx[i].x,sy[k].y,lx[j].x,ly[l].y),min);
							System.out.println(sx[i].x+" "+sy[k].y+" "+lx[j].x+" "+ly[l].y);
							System.out.println(i+" "+j+" "+k+" "+l);
							}
						}
					}
				}
			}
		}
		return min;
	}
	
	public static void first(pair[] arr){
		Arrays.sort(arr,new Comparator<pair>(){
			public int compare(pair p1, pair p2){
				return p1.x-p2.x;
			}
		});
	}
	public static void second(pair[] arr){
		Arrays.sort(arr,new Comparator<pair>(){
			public int compare(pair p1, pair p2){
				return p1.y-p2.y;
			}
		});
	}

	//	public static ArrayList<Integer> sx(pair[]arr, boolean[] v){
	//		ArrayList<Integer> ret = new ArrayList<Integer>();
	//		for(int i = 0;i<4;i++){
	//			int min = Integer.MAX_VALUE;
	//			int index = 0;
	//			for(int j = 0;j<arr.length;j++){
	//				if(!v[j]&&min>arr[j].x){
	//					v[j] = true;
	//					min = arr[j].x;
	//					index = j;
	//				}
	//			}
	//			ret.add(index);
	//		}
	//		return ret;
	//	}
	//	public static ArrayList<Integer> lx(pair[] arr, boolean[] v){
	//
	//		ArrayList<Integer> ret = new ArrayList<Integer>();
	//
	//		for(int i = 0;i<4;i++){
	//			int max = Integer.MIN_VALUE;
	//			int index = 0;
	//			for(int j = 0;j<arr.length;j++){
	//				if(!v[j]&&max<arr[j].x){
	//					v[j] = true;
	//					max = arr[j].x;
	//					index = j;
	//				}
	//			}
	//			ret.add(index);
	//		}
	//		return ret;
	//	}
	//	public static ArrayList<Integer> sy(pair[] arr, boolean[] v){
	//
	//		ArrayList<Integer> ret = new ArrayList<Integer>();
	//		
	//		for(int i = 0;i<4;i++){
	//			int min = Integer.MAX_VALUE;
	//			int index = 0;
	//			for(int j = 0;j<arr.length;j++){
	//				if(!v[j]&&min>arr[j].y){
	//					v[j] = true;
	//					min = arr[j].y;
	//					index = j;
	//				}
	//			}
	//
	//			ret.add(index);
	//		}
	//		return ret;
	//	}
	//	public static ArrayList<Integer> ly(pair[] arr, boolean[] v){
	//
	//		ArrayList<Integer> ret = new ArrayList<Integer>();
	//		
	//		for(int i = 0;i<4;i++){
	//			int max = Integer.MIN_VALUE;
	//			int index = 0;
	//			for(int j = 0;j<arr.length;j++){
	//				if(!v[j]&&max<arr[j].y){
	//					v[j] = true;
	//					max = arr[j].y;
	//					index = j;
	//				}
	//			}
	//			ret.add(index);
	//		}
	//		return ret;
	//	}
	public static int area(int x1, int y1, int x2, int y2){
		return Math.abs(x2-x1)*Math.abs(y2-y1);
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
			return x + " " + y;
		}
	}
}
