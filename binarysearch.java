package usaco;

public class binarysearch {
	public static int binarySearch(int x, int[] arr){
		
		int upper = arr.length-1;
		int lower = 0;
		int ret = 0;
		
		while(upper>=lower){
			int mid = (upper+lower)/2;
			if(arr[mid]==x){
				return mid+1;
			}
			if(arr[mid]>x){
				upper = mid-1;
			}
			if(arr[mid]<x){
				lower = mid+1;
			}
		}
		return lower;
		
	}
}
