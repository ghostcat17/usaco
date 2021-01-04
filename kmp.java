package usaco;

public class kmp {
	public static void main(String[] args){
		
		
	}
	public static int kmp(String s, String m){
		int count = 0;
		int i = 0;
		int j = 0;
		int[] arr = lps(m);
		while(i<s.length()){
			if(s.charAt(i)==m.charAt(j)){
				j++;
				i++;
			}
			if(j==m.length()){
				count++;
				j = arr[j-1];
			}
			else if(i<s.length()&&s.charAt(i)!=m.charAt(j)){
				if(j>0){
					j = arr[j-1];
				}
				else{
					i++;
				}
			}
		}
		return count;
		
	}
	public static int[] lps(String m){
		int[] arr = new int[m.length()];
		int i =1;
		int j = 0;
		arr[0] = 0;
		while(i<arr.length){
			if(m.charAt(i)==m.charAt(j)){
				arr[i] = ++j;
				i++;
			}
			else{
				if(j!=0){
					j = arr[j-1];
				}
				else{
					arr[i] = 0;
					i++;
				}
			}
		}
	
		return arr;
	
	}
}
