package com.hexaware.Exception;

public class InvalidEmailFormat extends Exception {
	public InvalidEmailFormat() {
		System.out.println("From InvalidEmailFormat constr...");
	}

	public String toString() {
		return "InvalidEmail ....";
	}
}
