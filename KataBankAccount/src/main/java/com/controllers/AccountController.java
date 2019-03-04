package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exception.AccountNotFoundException;
import com.exception.InsufficientBalanceException;
import com.service.AccountService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService ;
	
	@RequestMapping(value="/deposit/{accountNumber}/{amount}",method=RequestMethod.POST)
	public void depositTransaction(@PathVariable("accountNumber")String accountNumber,@PathVariable("amount") Double amount) throws AccountNotFoundException{
		accountService.depositAmountTransaction(accountNumber, amount);
	}
	
	@RequestMapping(value="/withdraw/{accountNumber}/{amount}",method=RequestMethod.POST)
	public void withdrawTransation(@PathVariable("accountNumber")String accountNumber,@PathVariable("amount") Double amount) throws AccountNotFoundException, InsufficientBalanceException{
		accountService.withdrawAmountTransaction(accountNumber, amount);
	}
	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
