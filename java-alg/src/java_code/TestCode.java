package java_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class TestCode {
	public static void main(String[] args) {
		double[] array = new double[] {
				4.12, 6.421, 1.21, 3, 4, 9.3, 3.45, 5.3221,10
		};
		double[] sortArray = sort(array);
		System.out.println(Arrays.toString(sortArray));
	}
	
	public static double[] sort(double[] array) {
		int len = array.length;
		double min = array[0];
		double max = array[0];
		
		for(int i = 1; i < len; i++) {
			if(max < array[i]) {
				max = array[i];
			}
			if(min > array[i]) {
				min = array[i];
			}
		}
		double d = max - min;
		
		int bucketSize = len;
		List<LinkedList<Double>> bucketList = new 
				ArrayList<LinkedList<Double>>(bucketSize);
		for(int i = 0; i < len; i++) {
			bucketList.add(new LinkedList<Double>());
		}
		
		for(int i = 0; i < len; i++) {
			int num = (int) ((array[i]-min)*(bucketSize-1)/d);
			bucketList.get(num).add(array[i]);
		}
		
		for(int i = 0; i < bucketSize; i++) {
			Collections.sort(bucketList.get(i));
		}
		
		double[] sortArray = new double[len];
		int index = 0;
		for(LinkedList<Double> list : bucketList) {
			for(Double el : list) {
				sortArray[index++] = el;
			}
		}
		
		return sortArray;
	}
}
