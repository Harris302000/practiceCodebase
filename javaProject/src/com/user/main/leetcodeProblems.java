package com.user.main;

import java.util.Arrays;
import java.util.Comparator;

public class leetcodeProblems {

	public void leetcodemain() {
		// TODO Auto-generated method stub
		String s = "   fly me   to   the moon  ";
		System.out.println("lengthOfLastWord::"+lengthOfLastWord(s));
	}
	
	
	public int lengthOfLastWord(String s) {

		// Approach 1
//		String[] words = s.trim().split("\\s+");
//	    return words[words.length - 1].length();

		// Approach 2 - efficient
//		int length = 0;
//	    int i = s.length() - 1;
//
//	    while (i >= 0 && s.charAt(i) == ' ') {
//	        i--;
//	    }
//
//	    while (i >= 0 && s.charAt(i) != ' ') {
//	        length++;
//	        i--;
//	    }
//	    return length;

		// Approach 3
		return Arrays.stream(s.trim().split("\\s+")).reduce((first, second) -> second).orElse("").length();

	}
	
	
	public int[] plusOne(int[] digits) {

	        
	        
	        return digits;
	    }

}
