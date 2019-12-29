package java_code;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

public class BitMapCode {
	public static void main(String[] args) {
		BitSet bs1 = new BitSet();
		BitSet bs2 = new BitSet();
 		bs1.set(2,true);
 		bs1.set(3,true);
		bs2.set(2,true);
		bs1.andNot(bs2);
		System.out.println(bs1);
		
		Random random = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			int randomNum = random.nextInt(10);
			list.add(randomNum);
		}
		System.out.println("产生的随机数有");
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		BitSet bitSet = new BitSet(10);
		for(int i = 0; i < 10; i++) {
			bitSet.set(list.get(i));
		}
		System.out.println("-------------");
		for(int i = 0; i < 10; i++) {
			if(!bitSet.get(i)) {
				System.out.println(i);
			}
		}
	}
}
