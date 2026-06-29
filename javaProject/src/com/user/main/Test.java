package com.user.main;

public class Test extends dummy{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dummy t = new Test();
        t.show();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}



interface A {

	void run();
	
    default void show() {
        System.out.println("A");
    }
}

abstract class dummy implements A {
	
	public void show() {
		System.out.println("b");
	}
	
}


