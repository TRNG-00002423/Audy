package com.rev.custom;

public class BankAccountManager {

  public static void main(String[] args) {
    
    BankAccount account = new BankAccount(100);

    try {
      account.withdraw(110);
    } catch (InsufficientFundsException e) {
      System.out.println(e.getMessage());
    }
  }
  
}
