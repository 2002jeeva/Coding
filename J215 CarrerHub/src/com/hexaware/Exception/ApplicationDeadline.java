package com.hexaware.Exception;

public class ApplicationDeadline extends Exception{
	public ApplicationDeadline() {
		System.out.println("From ApplicationDeadline constr...");
	}

	public String toString() {
		return "ApplicationDeadline ....";
	}
}
