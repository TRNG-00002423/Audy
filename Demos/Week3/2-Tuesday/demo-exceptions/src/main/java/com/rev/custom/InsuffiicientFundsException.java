package com.rev.custom;

public class InsuffiicientFundsException extends Exception {
  
  private double shortFall;

  public InsuffiicientFundsException(double shortFall){
    super("Withdrawal failed! You are short by: " + shortFall);
    this.shortFall = shortFall;
  }

  public double getShortFall(){
    return shortFall;
  }
}
