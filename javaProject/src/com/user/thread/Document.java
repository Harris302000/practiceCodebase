package com.user.thread;

public class Document {

    private int id;

    private String base64;

    public Document(int id,
                    String base64) {
    	
    	System.out.println("Inside document constructor");

        this.id = id;
        this.base64 = base64;

    }

    public int getId() {

        return id;

    }

    public String getBase64() {

        return base64;

    }

}
