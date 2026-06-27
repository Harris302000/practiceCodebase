package com.example.userservice.genericfunctions;

public class ResponseCreator {

	 private String response;
	    private int statusCode;

	    public ResponseCreator(String response, int statusCode) {
	        this.response = response;
	        this.statusCode = statusCode;
	    }

	    public String getResponse() {
	        return response;
	    }

	    public int getStatusCode() {
	        return statusCode;
	    }
	
	
}
