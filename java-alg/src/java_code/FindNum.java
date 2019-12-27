package java_code;

import java.util.Arrays;

public class FindNum {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		for(int i = 0; i < 10; i++) {
			numbers = findNearestNumber(numbers);
			outPutNumbers(numbers);
		}
	}
	
	public static void outPutNumbers(int[] numbers) {
		for(int i : numbers) {
			System.out.print(i);
		}
		System.out.println();
	}
	
	public static int[] findNearestNumber(int[] numbers) {
		//1.从后面向前查找逆序区域，找到逆序区域的前一位，也就是数组置换的边界
		int index = findTransferPoint(numbers);
		//2.如果index = 0 说明数组已是逆序，即是最大值
		if(index == 0) {
			return null;
		}
		//3.把逆序的前一位与逆序区域中刚好大于这个数的数字交换
		//为避免直接修改入参，复制入参
		int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
		exchangeHead(numbersCopy, index);
		//4.将逆序区域转顺序然后输出
		reverse(numbersCopy, index);
		return numbersCopy;
	}
	
	public static int findTransferPoint(int[] numbers) {
		for(int i = numbers.length-1; i > 0; i--) {
			if(numbers[i] > numbers[i-1]) {
				return i;
			}
		}
		return 0;
	}
	
	public static int[] exchangeHead(int[] numbers, int index) {
		int head = numbers[index-1];
		for(int i = numbers.length-1; i > 0; i--) {
			if(head < numbers[i]) {
				numbers[index-1] = numbers[i];
				numbers[i] = head;
				break;
			}
		}
		return numbers;
	}
	
	public static int[] reverse(int[] num, int index) {
		for(int i = index, j = num.length-1; i < j; i++,j--) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
		return num;
	}
}


