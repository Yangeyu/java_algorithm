package java_code;

import java.util.Arrays;

public class DynamicProgramme {
	public static void main(String[] args) {
		int w = 10;
		int[] p = {5,5,3,4,3};
		int[] g = {400, 500, 200, 300, 350};
		System.out.println(getBestProgramme(w, p, g));
	}
	
	public static int getBestProgramme(int w, int[] p, int[] g) {
		int[] result = new int[w+1];
		for(int i = 0; i < g.length; i++) {
			for(int j = w; j >= 1; j--) {
				
				if(j >= p[i]) {
					result[j] = Math.max(result[j], result[j-p[i]] + g[i]);
				}
			}
			System.out.println(Arrays.toString(result));
		}
		
		return result[w];
	}
}
