package com.capgemini.ui;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.service.Bank;
import com.capgemini.service.SBIBank;

public class Client {

	public static void main(String[] args) {
		Bank bank = new SBIBank();
		try
		{
			System.out.println(bank.createAccount(101, 3000));
			System.out.println(bank.createAccount(102, 3000));
			
			System.out.println("Balance after withdrawing = "+bank.withdrawAmount(101, 2000));
			
			int a[]=bank.fundTransfer(101,102,500);
			
			System.out.println("Sender balance after amount transfer = "+a[0]);
			System.out.println("Reciever balance after amount transfer = "+a[1]);
			
			System.out.println("Account balance after the deposit = "+bank.depositAmount(101, 500));
			
			System.out.println("Checking for minimum balance for new account");
			System.out.println(bank.createAccount(103,300));
			
		}
		catch(InsufficientOpeningAmountException iae) {
			System.out.println("Minimum Balance must be 500");
		}
		catch(InvalidAccountNumberException ib)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ibe){
			System.out.println("insufficient balance");
		}
	}

}