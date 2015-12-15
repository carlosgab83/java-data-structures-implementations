package sorting;

import java.util.*;

public class MergeSort{

	private String[] array;

	public String[] getArray(){
		return this.array;
	}

	public void setArray(String[] array){
		this.array = array;
	}

	public MergeSort(String[] array){
		setArray(array);
	}

	public String[] sort(){
		setArray(doMergeSort(getArray()));
		return getArray();
	}

	// Private

	private int getMidIndex(String[] array){
		return (int)(array.length/2);
	}

	private String[] getLeftArray(String[] array, int index){
		return Arrays.copyOfRange(array, 0, index);
	}

	private String[] getRightArray(String[] array, int index){
		return Arrays.copyOfRange(array, index, array.length);
	}

	private String[] doMergeSort(String[] array){
		if(array.length == 1){
			return array;
		}

		int midIndex   = getMidIndex(array);
		String[] left  = getLeftArray(array, midIndex);
		String[] right = getRightArray(array, midIndex);
		return doMerge( doMergeSort(left), doMergeSort(right) );
	}


	private String[] doMerge(String[] left, String[] right){
		int leftLength  = left.length;
		int rightLength = right.length;
		int l = 0;
		int r = 0;
		int i = 0;
		String[] result = new String[leftLength + rightLength];

		while(l < leftLength && r < rightLength)
			if(Integer.parseInt(left[l]) < Integer.parseInt(right[r]))
				result[i++] = left[l++];
			else
				result[i++] = right[r++];

		while(l < leftLength)
			result[i++] = left[l++];

		while(r < rightLength)
			result[i++] = right[r++];

		return result;
	}
}