package java_code;

public class GCD {
	public static void main(String[] args) {
		System.out.println(gcd(25,5));
		System.out.println(gcd(100,80));
	}
	
	public static int gcd(int a, int b) {
		if(a == b) return a;
		if((a&1)==0 && (b&1)==0) {
			return gcd(a>>1, b>>1)<<1;
		}else if((a&1)==0 && (b&1) != 0) {
			return gcd(a>>1, b);
		}else if((a&1) != 0 && ((b&1) == 0)) {
			return gcd(a, b>>1);
		}else {
			int max = a>b?a:b;
			int min = a<b?a:b;
			return gcd(min, max-min);
		}
	}
}
