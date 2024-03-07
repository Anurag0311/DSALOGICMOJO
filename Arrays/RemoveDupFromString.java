package com.anurag.Arrays;

public class RemoveDupFromString {

	static char[] removeDuplicates(String string) {
		int ascii[]=new int[256];
		char str[]=string.toCharArray();
		for(int i=0;i<str.length;i++) {
			if(ascii[str[i]]==0) {
				ascii[str[i]]=-1;
			}
			else if(ascii[str[i]]==-1) {
				str[i]='\0';
			}
		}
		
		return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
