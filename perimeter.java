package usaco;
import java.io.*;
import java.util.*;
public class perimeter {
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("poker.in")));
		//PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("poker.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		StringTokenizer st;
		int sx = Integer.MAX_VALUE, sy = Integer.MAX_VALUE;
		for(int i = 0;i<n;i++){
			
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y<sy || (y==sy && x<sx)) {
				sy=y;
				sx=x;
			}
			if(!map.containsKey(x)){
				map.put(x, new HashSet<Integer>());
			}
			map.get(x).add(y);
		}
		dfs(map, sx-1, sy);
		
		
	}
	public static int dfs(HashMap<Integer, HashSet<Integer>> map, int a, int b){
		map.get(a).remove(b);
		
	}
}
