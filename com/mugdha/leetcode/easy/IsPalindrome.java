package com.mugdha.leetcode.easy;

public class IsPalindrome {

	public static void main(String args[]) {
		System.out.println(isPalindrome(1221));
	}
	
	public static boolean isPalindrome(int x) {
		
		if(x < 0 || ( x%10 == 0 && x != 0 )) {
			return false;
		}
		
		int reversedNumber = 0;
		while(x > reversedNumber) {
			reversedNumber = reversedNumber * 10 + x % 10;
			x = x/10;
		}
		
        return x == reversedNumber || x == reversedNumber/10;
    }
}
