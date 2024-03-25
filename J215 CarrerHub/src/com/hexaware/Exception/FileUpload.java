package com.hexaware.Exception;

public class FileUpload extends Exception{
	public FileUpload() {
		System.out.println("From FileUpload constr...");
	}

	public String toString() {
		return "Wrong File format ....";
	}
}
