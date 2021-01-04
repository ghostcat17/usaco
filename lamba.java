package usaco;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class lamba {
	public static void main(String[] args){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		arr.add(1);
		arr.add(2);
		arr.add(3);
		
		arr.forEach((a)->System.out.println(a));
	}
}
