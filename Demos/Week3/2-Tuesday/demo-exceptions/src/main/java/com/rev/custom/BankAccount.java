package com.rev.custom;

import javax.naming.InsufficientResourcesException;

public class BankAccount {
  private double balance; //1000
  public BankAccount(double balance) {
    this.balance = balance;
  }

  public void withdraw(double amount) throws InsufficientResourcesException{
   if(amount>balance){
    double shortFall = amount - balance;
    throw new InsufficientFundsException(shortFall);
  }
  balance -= amount; //2000
  System.out.println("Withdrawal Successful");
}
}
