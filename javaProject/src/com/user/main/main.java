/**
 * 
 */
package com.user.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.DoubleToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * 
 */
public class main {

	/**
	 * @param args
	 * @author Agnes Harris Fernando
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Hello world!!!");
		
		MyArrayList<Integer> list1 = new MyArrayList<>();
		
		List<Integer> list =new ArrayList<>();
		list.add(1);
		list.add(0);
		list.add(2);
		list.add(0);
		list.add(3);
		list.add(0);
		
		
		List<String> listSTR = List.of("Flower","Flight","Flow");
		
		streamTestCases stc = new streamTestCases();
//		stc.setAge(4);
//		stc.testCases();
		stc.moveAllZeroToEnd(list);
		stc.sortMapValues();
		stc.ReverseWordAndCharacters();
		stc.findDuplicateFromList();
		stc.mergeTwoArrays();
		stc.findFirstRepeatedCharsFormString();
		stc.findStatrtsWith();
		stc.primeNumber();
		stc.findFreqencyOfChar();
		stc.findMaxSubStringWithoutRepeatedChars();
		
		
		
		
		ThreadTestCases TTC = new ThreadTestCases();
//		TTC.ThreadMethod();;
		 
		
	}

}
