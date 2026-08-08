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
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.user.designpattern.builderdesignpattern.myComputer;
import com.user.genericfunctions.databaseConnection;
import com.user.interfaces.defaultInterfaces;
import com.user.interfaces.sumInterface;
import com.user.lists.LinkedList;
import com.user.lists.MyArrayList;
import com.user.streams.streamTestCases;
import com.user.thread.ThreadTestCases;


/**
 * 
 */
public class main extends leetcodeProblems{

			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello world!!!");

		
		boolean testFlag = false;
		boolean leetCodeFlag =false;
		boolean designpattern =false;
		
		// MyArrayList<Integer> list1 = new MyArrayList<>();
		threadtestcalling();

		if (testFlag) {
			databaseConnection DBconnect = databaseConnection.getInstance();
			List<List<String>> result = DBconnect.getdatafromdb("select * from students");
			System.out.println("result::" + result);
			streamtestcalling();
			threadtestcalling();
			linkedListtestcalling();
			interfacetestcalling();
		}
		
		
		if (leetCodeFlag) {
			System.out.println("Testing leetcodeProblems");
			leetcodeProblems lcProb = new leetcodeProblems();
			lcProb.leetcodemain();
		}
		
		
		if (designpattern) {
			//Builder Design pattern
//		myComputer myCom = new myComputer("1TB","24 GB","Version  10.3","510 MB",false);
			myComputer myCom = new myComputer.computerbuilder("1TB", "24 GB").addBluetooth(true).build();
			System.out.println(myCom.toString());
		}
		 
		
	}

	public static void streamtestcalling() {
		List<String> listSTR = List.of("Flower", "Flight", "Flow");
		
		List<Integer> list = new ArrayList<>();
		int[] numbers = {1,0,2,0,3,0};
		Arrays.stream(numbers).forEach(i -> list.add(i));

		streamTestCases stc = new streamTestCases();
		stc.setAge(4);
		stc.testCases();
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
//		TTC.ThreadMethod();		
		TTC.start();
		
		ThreadTestCases TTC1 = new ThreadTestCases();
//		TTC1.ThreadMethod();
		TTC1.start();
		
		ThreadTestCases TTC2 = new ThreadTestCases();
//		TTC2.ThreadMethod();
		TTC2.start();
	}

	public static void linkedListtestcalling() {
		LinkedList LL = new LinkedList(4);
		int[] numbers = { 100, 101, 102 };

		Arrays.stream(numbers).forEach(s -> LL.append(s));

		System.out.println("Value removed::" + LL.removeLast().value);

		LL.prepend(1);

		LL.insert(2, 0);

		LL.reverse();

		LL.printLinkedList();

		LL.getLength();

		System.out.println("Get value::" + LL.get(0).value);

	}

	public static void interfacetestcalling() {

		defaultInterfaces defaultIF = new defaultInterfaces();

		sumInterface sumIF = (a, b) -> a + b;

		mathOperations math = new mathOperations();

		int sum = math.addNumbers(0, 2);
		System.out.println("sum::" + sum);

		sum = sumIF.addNumbers(sum, sum);
		System.out.println("sum::" + sum);

		IntStream.rangeClosed(1, 5).forEach(i -> math.debitAmount(i * i));

		math.checkbalance();

		defaultIF.checkAge.accept(22);
		;
		System.out.println(defaultIF.alert.get());
		System.out.println(defaultIF.checkAccountNumber.apply("123456789098"));
		System.out.println(defaultIF.namecheck.test("Agnes Harris"));

	}


}

class mathOperations extends cardetails implements sumInterface {

	private double totalamount;

	mathOperations() {
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

		System.out.println("Amount Debited ::" + amount);

		totalamount = totalamount + amount;

		System.out.println("Balance Amount ::" + totalamount);

	}

	@Override
	void checkbalance() {
		// TODO Auto-generated method stub

		System.out.println("Checking balance Amount...............");

		System.out.println("Balance Amount ::" + totalamount);

	}

}

abstract class cardetails {

	abstract void debitAmount(double amount);

	abstract void checkbalance();

}
