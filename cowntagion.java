
import java.io.*;
import java.util.*;

public class cowntagion {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer>[] arr = new ArrayList[n];
		for(int i = 0;i<n-1;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			if(arr[a]==null){
				arr[a] = new ArrayList<Integer>();
			}
			if(arr[b]==null){
				arr[b] = new ArrayList<Integer>();
			}

			arr[a].add(b);


			arr[b].add(a);

		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		Long sum = 0L;
		boolean[] visited = new boolean[n];
		visited[0] = true;
		while(!q.isEmpty()){
			int curr = q.poll();
			
			int count = 0;
			for(int i = 0;i<arr[curr].size();i++){

				if(!visited[arr[curr].get(i)]){
					q.add(arr[curr].get(i));
					visited[arr[curr].get(i)] = true;
					count++;
				}
			}
				int temp = 1;
				while(temp<count+1){
					temp*=2;
					sum++;
				}
				
				sum+=count;
			
		}
		pw.println(sum);
		pw.close();
	}

}
