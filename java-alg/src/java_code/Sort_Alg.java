package java_code;

import java.util.Arrays;

public class Sort_Alg {
	public static void main(String[] args) {
		System.out.println("Hello World!!");
		
		int[] arr = new int[] {
				4,4,6,5,3,7,2,8,1
		};
		fast_sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 快速排序：
	 * 	时间复杂度：O(nlog(n))
	 * 	空间复杂度：O(log(n))
	 * @param nums
	 * @param startIndex
	 * @param endIndex
	 */
	public static void fast_sort(int[] nums, int startIndex, int endIndex) {
		//当元素个数小于3时退出
		if(endIndex-startIndex < 2) return ;
		//取得基准元素位置
		int pivot_index = patition(nums, startIndex, endIndex);
		
		//根据基准位置分成两部分排序
		fast_sort(nums, startIndex, pivot_index-1);
		fast_sort(nums, pivot_index+1, endIndex);
	}
	
	/**
	 * 分段：左边小于右边
	 * @param arr
	 * @param startIndex
	 * @param endIndex
	 * @return 返回基准值的下标：index
	 */
	public static int patition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[startIndex];		//基准点
		int left = startIndex;
		int right = endIndex;
		
		while(left < right) {
			//找出右边小于 pivot 的元素
			while(left < right && arr[right] > pivot) --right;
			//找出左边大于 pivot 的元素
			while(left < right && arr[left] <= pivot) ++left;
			
			//交互两个值
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		arr[startIndex] = arr[left];
		arr[left] = pivot;
		return left;
	}
}
