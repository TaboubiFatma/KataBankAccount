package com.entites;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * An entity representing Customer's informations.
 *
 */

@Entity
@Table(name="CUSTOMER")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDENTITY")
	private String identityNumber ;
	 
	@Column(name="NAME")
	private String customerName;
	 
	@Column(name="FIRST_NAME")
	private String customerFirstName;
	
	@OneToMany(mappedBy="customer",fetch=FetchType.LAZY)
	private Collection<Account> accounts ;
 
	public Customer() {
		super();
	}

	public Customer(String identityNumber, String customerName, String customerFirstName) {
		super();
		this.identityNumber = identityNumber;
		this.customerName = customerName;
		this.customerFirstName = customerFirstName;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerFirstName == null) ? 0 : customerFirstName.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((identityNumber == null) ? 0 : identityNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (customerFirstName == null) {
			if (other.customerFirstName != null)
				return false;
		} else if (!customerFirstName.equals(other.customerFirstName))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (identityNumber == null) {
			if (other.identityNumber != null)
				return false;
		} else if (!identityNumber.equals(other.identityNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [identityNumber=" + identityNumber + ", customerName=" + customerName + ", customerFirstName="
				+ customerFirstName + "]";
	}
}
