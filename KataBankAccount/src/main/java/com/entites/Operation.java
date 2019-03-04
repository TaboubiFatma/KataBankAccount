package com.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * An entity representing Operation's informations.
 *
 */

public class Operation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="CODE")
	private String operationCode ;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="DATE_OPERATION")
    @Temporal(TemporalType.DATE)
    private Date operationDate ;
	
	@Column(name="TYPE_OP")
	private String operationType;
	
	@ManyToOne
    @JoinColumn(name = "ACCOUNT", referencedColumnName = "ACCOUNT_NUMBER")
	private Account account ;

	public Operation() {
		super();
	}

	public Operation(double amount, Date operationDate, String sensOperation, Account account) {
		super();
		this.amount = amount;
		this.operationDate = operationDate;
		this.operationType = sensOperation;
		this.account = account;
	}

	public String getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(String operationCode) {
		this.operationCode = operationCode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((operationCode == null) ? 0 : operationCode.hashCode());
		result = prime * result + ((operationDate == null) ? 0 : operationDate.hashCode());
		result = prime * result + ((operationType == null) ? 0 : operationType.hashCode());
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
		Operation other = (Operation) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (operationCode == null) {
			if (other.operationCode != null)
				return false;
		} else if (!operationCode.equals(other.operationCode))
			return false;
		if (operationDate == null) {
			if (other.operationDate != null)
				return false;
		} else if (!operationDate.equals(other.operationDate))
			return false;
		if (operationType == null) {
			if (other.operationType != null)
				return false;
		} else if (!operationType.equals(other.operationType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Operation [operationCode=" + operationCode + ", amount=" + amount + ", operationDate=" + operationDate
				+ ", sensOperation=" + operationType + ", account=" + account + "]";
	}
}