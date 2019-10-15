package test;

import main.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterResolutionException;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account = new Account(000123,0.0);
    @Test
     void testClassName(){
        assertEquals("Account",account.getClass().getSimpleName());
    }
    @Test
     void testPackageName(){
        assertEquals("main",account.getClass().getPackageName());
    }
    @Test
     void getAccountNumberTest(){
        account.setAccountNumber(1);
        assertEquals(1,account.getAccountNumber(),0.1);
    }
    @Test
     void getBalanceTest(){
        account.setBalance(2000.00);
        assertEquals(2000.00,account.getBalance(),0.2);
    }
    @Test
     void setAccountNumberTest(){
        account.setAccountNumber(10);
        assertEquals(10,account.getAccountNumber());
    }
    @Test
     void setBalanceTest(){
        account.setBalance(200.00);
        assertEquals(200.00,account.getBalance());
    }
    @Test
     void creditTest(){
        account.setBalance(100);
        account.credit(200);
        assertEquals(300,account.getBalance(),0.2);
    }
    @Test
     void debitTest(){
        account.setBalance(100.00);
        account.debit(40.00);
        try {
            assertEquals(60.00, account.getBalance(), 0.2);
        }catch(ParameterResolutionException e) {
            account.setBalance(100.00);
            assertEquals("amount withdrawn exceeds the current balance!", account.debit(120.00));
        }

    }
    @Test
     void printTest(){
        account.setBalance(200.00);
        account.setAccountNumber(20);
        assertEquals(String.format("A/C no: %d Balance=$%.0f",account.getAccountNumber(),account.getBalance()),account.print());
    }
}