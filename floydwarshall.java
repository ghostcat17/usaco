package usaco;

public class floydwarshall {
	public static final int INF = 99999;
	public static void main(String[] args){
		   
	        int graph[][] = { {0,   5,  INF, 10}, 
	                          {INF, 0,   3, INF}, 
	                          {INF, INF, 0,   1}, 
	                          {INF, INF, INF, 0} 
	                        }; 
	        printSolution(floydwarshall(graph));
	}
	 static void printSolution(int dist[][]) 
	    { 
	        System.out.println("The following matrix shows the shortest "+ 
	                         "distances between every pair of vertices"); 
	        for (int i=0; i<dist.length; ++i) 
	        { 
	            for (int j=0; j<dist.length; ++j) 
	            { 
	                if (dist[i][j]==INF) 
	                    System.out.print("INF "); 
	                else
	                    System.out.print(dist[i][j]+"   "); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	  
	   
	public static int[][] floydwarshall(int[][] graph){
		int v = graph.length;
		int[][] ret = graph.clone();
		int i, j, k; //i is each src index, j is the end index, k is the intermediate 
		for(k = 0;k<v;k++){
			for(i = 0;i<v;i++){
				for(j = 0;j<v;j++){
					if(ret[i][k]+ret[k][j]<ret[i][j]){
						ret[i][j] = ret[i][k]+ret[k][j];
					}
				}
			}
		}

		return ret;
	}
}
