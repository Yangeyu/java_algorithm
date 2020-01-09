package java_code;



public class TestCode {
	public static void main(String[] args) {
		int w = 10;
		int[] p = {5,5,3,4,3};
		int[] g = {400, 500, 200, 300, 350};
		System.out.println(findNum(w, p, g));
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
	
	public static int findNum(int w, int[] p, int[] g) {
		int[] result = new int[w+1];
		
		for(int i = 0; i < g.length; i++) {
			for(int j = w; j > 0; j--) {
				if(j >= p[i]) {
					result[j] = Math.max(result[j], result[j-p[i]] + g[i]);
				}
			}
		}
		return result[w];
	}
	
	
}
