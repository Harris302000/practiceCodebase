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

import com.user.interfaces.sumInterface;
import com.user.lists.LinkedList;
import com.user.lists.MyArrayList;
import com.user.streams.streamTestCases;
import com.user.thread.ThreadTestCases;

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
		
		streamtestcalling(list);
		
		threadtestcalling();
		
		linkedListtestcalling();
	
		
		
		mathOperations math = new mathOperations();
		
		int sum = math.addNumbers(0, 2);
		System.out.println("sum::"+sum);
		
		
		for(int i=1;i<=5;i++) {
			math.debitAmount(i*i);
		}
		
		math.checkbalance();
		
		
	}
	
	public static void streamtestcalling(List<Integer> list) {
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
		stc.maxSubArray();
	}
	
	
	public static void threadtestcalling() {
		
		ThreadTestCases TTC = new ThreadTestCases();
		TTC.ThreadMethod();
	}
	
	
	public static void linkedListtestcalling() {
		LinkedList LL = new LinkedList(4);

		LL.append(100);
		LL.append(101);
		LL.append(102);

		System.out.println("Value removed::" + LL.removeLast().value);

		LL.prepend(1);

		LL.insert(2, 0);

		LL.reverse();

		LL.printLinkedList();

		LL.getLength();

		System.out.println("Get value::" + LL.get(0).value);

	}
	

}


class mathOperations extends cardetails implements sumInterface {

	
	private double totalamount;
	
	mathOperations(){
		totalamount = 0;
	}
	
	
	@Override
	public int addNumbers(int a, int b) {
		// TODO Auto-generated method stub
		operationType("Sum of two numbers");
		return a + b;
		
	}

	@Override
	public void debitAmount(double amount) {
		// TODO Auto-generated method stub
		
		System.out.println("Amount Debited ::"+amount);
		
		totalamount = totalamount+amount;
		
		System.out.println("Balance Amount ::"+totalamount);
		
	}

	@Override
	void checkbalance() {
		// TODO Auto-generated method stub
		
		System.out.println("Checking balance Amount...............");
		
		System.out.println("Balance Amount ::"+totalamount);
		
	}
	
}


abstract class cardetails {
	
	abstract void debitAmount(double amount);
	
	abstract void checkbalance();

}
