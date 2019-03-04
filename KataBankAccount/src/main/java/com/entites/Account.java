package com.entites;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.entites.Customer;
import com.entites.Operation;


/**
 * An entity representing Account's informations.
 *
 */

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable{

	
	private static final long serialVersionUID = 1L;
		
	@Id
	@Size(max=11)
	@Column(name="ACCOUNT_NUMBER")
	private String accountNumber ;
		
	@Column(name="BALANCE")
	private BigDecimal accountBalance ;  
	  
	@Column(name="DATE_CREATION")
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	@ManyToOne
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "IDENTITY")
	private Customer customer ;   
	  
    @OneToMany(mappedBy="account",fetch=FetchType.LAZY)
	private Collection<Operation> operations ; 
  
	public Account() {
		super();
	}

	
	public Account(String accountNumber, BigDecimal balance, Date dateCreation) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = balance;
		this.dateCreation = dateCreation;
	}


	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountBalance == null) ? 0 : accountBalance.hashCode());
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountBalance == null) {
			if (other.accountBalance != null)
				return false;
		} else if (!accountBalance.equals(other.accountBalance))
			return false;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + accountBalance + ", dateCreation=" + dateCreation
				+ "]";
	} 
}