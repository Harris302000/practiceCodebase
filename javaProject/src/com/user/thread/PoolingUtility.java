package com.user.thread;

public class PoolingUtility {

	public PoolingUtility() {
		System.out.println("Inside Pooling Utility Contructor'");
	}
	
	
	public synchronized Document fetchDocument() {

		Document document = new Document(0, "123456789");

		if (document == null) {

			return null;

		}

		System.out.println(

				Thread.currentThread().getName()

						+ " Document Data Picked "

						+ document.getId()

		);

		return document;

	}

}