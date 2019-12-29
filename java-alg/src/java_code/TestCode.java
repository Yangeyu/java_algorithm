package java_code;



public class TestCode {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		for(int i = 0; i < 10; i++) {
			numbers = findNextNumber(numbers);
			outPutNumber(numbers);;
		}
	}
	
	
	public static int[] findNextNumber(int[] numbers) {
		//找到逆序的界限
		int index = findTransferNumber(numbers);
		if(index == 0) {
			return null;
		}
		
		exchangeNumber(numbers, index);
		reverse(numbers, index);
		return numbers;
	}
	
	public static int findTransferNumber(int[] numbers) {
		for(int i = numbers.length-1; i > 0; i--) {
			if(numbers[i] > numbers[i-1]) {
				return i;
			}
		}
		return 0;
	}
	
	public static int[] exchangeNumber(int[] numbers, int index) {
		int temp = numbers[index-1];
		for(int i = numbers.length-1; i > 0; i--) {
			if(temp < numbers[i]) {
				numbers[index-1] = numbers[i];
				numbers[i] = temp;
				break;
			}
		}
		return numbers;
	}
	
	public static int[] reverse(int[] numbers, int index) {
		for(int i = index, j = numbers.length-1; i < j; i++, j--) {
			int temp = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = temp;
		}
		return numbers;
	}
	
	public static void outPutNumber(int[] numbers) {
		for(int i : numbers) {
			System.out.print(i);
		}
		System.out.println();
	}
}
