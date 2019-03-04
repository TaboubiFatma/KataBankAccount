package com.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dal.AccountDAL;
import com.dal.OperationDAL;
import com.entites.Account;
import com.entites.Operation;
import com.exception.*;
import com.service.AccountService;


@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDAL accountDAL;
	
	@Autowired
	private OperationDAL operationDAL ; 
	
	@Override
	public void withdrawAmountTransaction(String accountNumber,Double amount) throws AccountNotFoundException,InsufficientBalanceException {
	  Account account = getAccountByAccountNumber(accountNumber);
	  if(account.getAccountBalance().compareTo(new BigDecimal(amount))< 0){
		  throw new InsufficientBalanceException("insufficient balance !");
	  }else{
		  // save withdraw transaction 
		  operationDAL.save(new Operation(amount,new Date(),"Withdraw",account));
		  // set the balance of the account
	      account.setAccountBalance(account.getAccountBalance().subtract(new BigDecimal(amount)));
	      accountDAL.save(account); 
	  }
	}

	@Override
	public void depositAmountTransaction(String accountNumber,Double amount) throws AccountNotFoundException{
		// save deposit transaction 
		Account account = getAccountByAccountNumber(accountNumber);
		operationDAL.save(new Operation(amount,new Date(),"Deposit",account));
		// set the balance of the account
	    account.setAccountBalance(account.getAccountBalance().add(new BigDecimal(amount)));
		accountDAL.save(account); 
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) throws  AccountNotFoundException {
		return accountDAL.findById(accountNumber).orElseThrow(() -> new AccountNotFoundException("Account does not exist !"));
	}

	public AccountDAL getAccountDAL() {
		return accountDAL;
	}

	public void setAccountDAL(AccountDAL accountDAL) {
		this.accountDAL = accountDAL;
	}

	public OperationDAL getOperationDAL() {
		return operationDAL;
	}

	public void setOperationDAL(OperationDAL operationDAL) {
		this.operationDAL = operationDAL;
	}
}
