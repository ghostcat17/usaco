

import java.io.*;
import java.util.*;

public class mooyomooyo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("mooyomooyo.in")));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("mooyomooyo.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] arr = new int[Integer.valueOf(st.nextToken())][10];
		int k = Integer.valueOf(st.nextToken());
		for(int i = 0;i<arr.length;i++){
			String line = br.readLine();
			for(int j = 0;j<10;j++){
				arr[i][j] = line.charAt(j)-'0';
			}
		}
		
		boolean cont = true;
		while(cont){
			cont = false;
			for(int i = 0;i<arr.length;i++){
				for(int j = 0;j<arr[i].length;j++){
					if(arr[i][j]!=0){
						
						if(bfs(arr,i,j,k)){
							cont = true;
						
						}
					}
				}
			}
			
			gravity(arr);
			
		}
//		int[][] ans = new int[arr.length][10];
//		for(int i = 0;i<arr.length;i++){
//			String line = br.readLine();
//			for(int j = 0;j<10;j++){
//				ans[i][j] = line.charAt(j)-'0';
//			}
//		}
//		for(int i = 0;i<arr.length;i++){
//			for(int j = 0;j<arr[i].length;j++){
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 0;i<arr.length;i++){
//			for(int j = 0;j<arr[i].length;j++){
//				System.out.print(Math.abs(arr[i][j]-ans[i][j]));
//			}
//			System.out.println();
//		}
		
		for(int[] a:arr){
			for(int c: a){
				pw.print(c);
			}
			pw.println();
		}
		pw.close();
	}
	public static boolean bfs(int[][] arr, int i, int j, int k){

		
		int current = arr[i][j];
		Queue<Integer> xq = new LinkedList<Integer>();
		Queue<Integer> yq = new LinkedList<Integer>();
		Queue<Integer> rxq = new LinkedList<Integer>();
		Queue<Integer> ryq = new LinkedList<Integer>();
		int[] dx = {-1,0,1,0};//RDLU
		int[] dy = {0,1,0,-1};//RDLU

		xq.add(i);
		yq.add(j);
	
		arr[i][j] = 0;
		int nums = 1;

		while(!xq.isEmpty()){
			int x = xq.remove();
			int y = yq.remove();
			
			
			rxq.add(x);
			ryq.add(y);
		
			for(int dir = 0;dir<4;dir++){

				if(x+dx[dir]==-1||y+dy[dir]==-1||x+dx[dir]==arr.length||y+dy[dir]==arr[0].length){
					continue;
				}
				if(arr[x+dx[dir]][y+dy[dir]]==current){
					
					xq.add(x+dx[dir]);
					yq.add(y+dy[dir]);
					arr[x+dx[dir]][y+dy[dir]] = 0;
					nums++;

				}

			}

		}
//		System.out.println(nums);
//		for(int a = 0;a<arr.length;a++){
//			for(int l = 0;l<arr[a].length;l++){
//				System.out.print(arr[a][l]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		if(nums<k){
			while(!rxq.isEmpty()){
				int x = rxq.remove();
				int y = ryq.remove();
				arr[x][y] = current;



			}
			return false;
		}
		return true;
	}
	public static void gravity(int[][] arr){

		for(int i = 0;i<10;i++){
			int j = arr.length-1;
			while(arr[j][i]!=0){
				j--;
			}
			int temp = j-1;
			while(temp>=0){
				if(arr[temp][i]==0){
					temp--;
				}
				else{
					arr[j][i] = arr[temp][i];
					arr[temp][i] = 0;
					j--;
				}
			}
		}
	}
}
