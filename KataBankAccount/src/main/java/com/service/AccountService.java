package com.service;

import com.entites.Account;
import com.exception.*;


/**
 * Business interface which defines {@link AccountService} to controller layer.
 *
 * Withdrawal/deposit an account.
 * Withdrawal: withdrawal into an account corresponding to the provided information.
 * Deposit: deposit into an account corresponding to the provided information.
 *
 * An Account is retrieved by this method :
 * {@link AccountService#getAccountByAccountNumber()} Those criteria should define an unique account.
 *
 */

public interface AccountService {
	
	/**
     * Method to get an account
     * @return Account
     */
	
	Account getAccountByAccountNumber (String accountNumber) throws  AccountNotFoundException;
	
	/**
     * Method to withDrawal an amount into account
     * @return void
     */
	void withdrawAmountTransaction(String accountNumber, Double amount) throws AccountNotFoundException,InsufficientBalanceException;
	
	/**
     * Method to deposit an amount into account
     * @return void
     */
	
	void depositAmountTransaction(String accountNumber,Double amount) throws AccountNotFoundException;

}
