package java_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
	public static void main(String[] args) {
		System.out.println("Hello World!!");
		double[] array = new double[] {
				4.12, 6.421, 1.21, 3, 4, 9.3, 3.45, 5.3221,10
		};
		double[] sortArray = bucketSort(array);
		System.out.println(Arrays.toString(sortArray));
	}
	/**
	 * 桶排序算法
	 * 	时间复杂度：O(n)
	 *  空间复杂度：O(n)
	 *  具有稳定性
	 * @param array
	 * @return sortArray
	 */
	public static double[] bucketSort(double[] array) {
		//1.得到数列的max 和 min， 求出差值d；
		double max = array[0];
		double min = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
			if(array[i] < min) {
				min = array[i];
			}
		}
		double d = max - min;
			
		//2.初始化桶
		int bucketNum = array.length;
		ArrayList<LinkedList<Double>> bucketList = new
				ArrayList<LinkedList<Double>>(bucketNum);
		for(int i = 0; i < array.length; i++) {
			bucketList.add(new LinkedList<Double>());
		}
		
		//3.遍历原始数组，将每个元素放入桶中
		for(int i = 0; i < array.length; i++) {
			int num = (int)((array[i]-min) * (bucketNum-1)/d);
			bucketList.get(num).add(array[i]);
		}
		
		//4.对每个桶内部进行排序
		for(int i = 0; i < bucketList.size(); i++) {
			//JDK底层分装了归并排序的算法
			Collections.sort(bucketList.get(i));
		}
		
		//5.输出全部元素
		double[] sortArray = new double[array.length];
		int index = 0;
		for(LinkedList<Double> list : bucketList) {
			for(double el : list) {
				sortArray[index++] = el;
			}
		}
		
		return sortArray;
	}
}
