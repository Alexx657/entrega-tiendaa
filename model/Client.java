package model;

import main.Payable;

public class Client  extends Person implements Payable{
	private int memberId;
	private Amount balance;

	public Client(int memberId, Amount balance) {
	
		final int MEMBER_ID= 456;
		final String BALANCE = "50.00€";
		this.memberId = getMemberId(); 
        double initialBalance = 0;
		this.balance = new Amount(initialBalance); 
	}
	
	
	public Client(String clientName) {
		// TODO Auto-generated constructor stub
	}


	public Client(String clientName, double initialBalance) {
	    this.name = clientName;
	    this.balance = new Amount(initialBalance);
	}


	//Getter y setter
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Amount getBalance() {
		return balance;
	}

	public void setBalance(Amount totalAmount) {
		this.balance = totalAmount;
	}



	@Override
	 public boolean pay(Amount amount) {
	        //Mira si el sueldo es suficiente para pagar

	        if (balance.getAmount() >= amount.getAmount()) {
	            // Resta el saldo inicial con el final.
	            balance.setAmount(balance.getAmount() - amount.getAmount());
	            // Mira si es saldo es positivo
	            if (balance.getAmount() >= 0) {
	                return true; // Si lo es, devuelve true.
	            } else {
	                // Si el balance es negativo devuelve un error.
	                balance.setAmount(balance.getAmount() + amount.getAmount());
	                return false; // Devuelve error.
	            }
	        } else {
	            return false; //Saldp insuciente
	        }
	    }


	public void setBalance(double totalAmount) {
		// TODO Auto-generated method stub
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

