package com.katabank.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Date;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entites.Account;
import com.exception.AccountNotFoundException;
import com.exception.InsufficientBalanceException;
import com.service.AccountService;
import com.service.OperationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KataBankAccountServiceTest.class)
public class KataBankAccountServiceTest {

	private static AccountService mockedAccountService ;
	private static OperationService mockedOperationService; 
	private static Account accountUnderTest;

	@BeforeClass
	public static void setUp(){
		mockedAccountService = mock(AccountService.class);
		mockedOperationService = mock(OperationService.class);
		accountUnderTest = new Account("21366987412",new BigDecimal(600.0), new Date());
	}
	
	@Test
	public void WhenMakingWithdrawAccountBalanceDecrease() throws AccountNotFoundException, InsufficientBalanceException{
		mockedAccountService.withdrawAmountTransaction(accountUnderTest.getAccountNumber(), 200.0);
		assertEquals(new BigDecimal(400.0), accountUnderTest.getAccountBalance());
	}
	
	@Test
	public void WhenMakingDepositAccountBalanceIncreases() throws AccountNotFoundException{
		mockedAccountService.depositAmountTransaction(accountUnderTest.getAccountNumber(), 100.0);
		assertEquals(new BigDecimal(500.0), accountUnderTest.getAccountBalance());
	}
	
	@Test
	public void WhenMakingDepositWithdrawAccountOperationsIncreases() {
		assertEquals(2, mockedOperationService.getAllHistoricTransactions(accountUnderTest.getAccountNumber()).size());
	}
}
