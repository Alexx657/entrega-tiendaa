package model;

import java.util.Scanner;

import main.Logable;

public class Employee extends Person implements Logable{
	private int employed;
	private static final int USER = 123;
	private static final String PASSWORD = "test";
	
	public boolean login( int employedId, String password) {
		return employed == USER && password.equals(PASSWORD); 
	}

	public void login(Scanner scanner) {
		// TODO Auto-generated method stub
	}
	

}
