package com.anurag.Arrays;

public class ElementsThatAppearsTwice {

	public void find2Element(int [] array) {
		int xor=array[0];
		for(int i=1;i<array.length;i++) {
			xor ^=array[i];
		}
		int most_rightbit=xor &~ (xor-1);
		int a=0,b=0;
		for(int i=0;i<array.length;i++) {
			int x=array[i];
			if((x & most_rightbit) !=0) {
				a ^= x;
			}
			else {
				b ^= x;
			}
		}
	}
	
	public static void main(String[] args) {
        ElementsThatAppearsTwice t = new ElementsThatAppearsTwice();
        int [] array = {2,4,7,9,2,4};
        t.find2Element(array);

    }

}
