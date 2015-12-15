import sorting.*;

import java.util.*;

public class Main{

	public static void main(String[] args){
		MergeSort mergeSort = new MergeSort(args);
		System.out.println(Arrays.toString(mergeSort.sort()));
	}
}