package com.hexaware.Exception;

public class SalaryCalulate extends Exception {
	public SalaryCalulate() {
		System.out.println("From SalaryCalulate constr...");
	}

	public String toString() {
		return "Wrong salary ....";
	}
}
