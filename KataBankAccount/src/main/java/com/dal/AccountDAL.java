package com.dal;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entites.Account;

/**
 * DAO interface which defines {@link AccountDAL} to service layer.
 *
 * The informations about all Accounts related to a customer is retrieved by this method :
 * {@link AccountDAL#getAllAccountsByCustomer()} Those criteria should define all Accounts by Customer.
 */

public interface AccountDAL extends JpaRepository<Account,String>{
	@Query("select a from Account a where a.customer.identityNumber =: customerIdentity")
	Collection<Account> getAllAccountsByCustomer(@Param("customerIdentity")String customerIdentity);
}
