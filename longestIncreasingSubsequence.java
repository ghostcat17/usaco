package usaco;

public class longestIncreasingSubsequence {
	public static void main(String[] args){
		System.out.println(lis(new int[]{1,2,3,4,5}));
	}
	public static int lis(int[] arr){
		int[] lis = new int[arr.length];
		
		for(int i = 0;i<arr.length;i++){
			lis[i] = 1;
		}
		
		for(int i = 1;i<arr.length;i++){
			for(int j = 0;j<i;j++){
				if(arr[i]>arr[j]&&lis[i]<lis[j]+1){
					lis[i] = lis[j]+1;
				}
			}
		}
		int ret = 0;
		for(int a:lis){
			if(a>0){
				ret = a;
			}
		}
	return ret; 
	}
}
