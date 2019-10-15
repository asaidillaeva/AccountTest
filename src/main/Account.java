package main;

public class Account{
    private int accountNumber;
    private double balance;

    public Account(int newAccountNumber,double newBalance) {
        this.accountNumber=newAccountNumber;
        this.balance=newBalance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }

    public void credit(double amount){
        double newBalance = balance+amount;
        balance = newBalance;
    }

    public String debit(double amount){
        if(amount>balance){
            return String.format("amount withdrawn exceeds the current balance!");
        }else{
            double newBalance = balance - amount;
            balance = newBalance;
        }

        return null;
    }
    public String print(){
        return String.format("A/C no: %d Balance=$%.0f",getAccountNumber(),getBalance());
    }
}
