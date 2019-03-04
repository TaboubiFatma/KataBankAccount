package com.service;

import java.io.ByteArrayInputStream;
import java.util.Collection;
import com.entites.Operation;


/**
 * Business interface which defines {@link OperationService} to controller layer.
 *
 * print document containing informations about all operations :
 * {@link OperationService#printHistoricTransactions()}.
 *
 * The informations about operations is retrieved by this method :
 * {@link OperationService#getAllHistoricTransactions()} Those criteria should define all Operation.
 */

public interface OperationService {
	
	/**
     * Method to get all operations
     * @return Collection<Operation>
     */
	Collection<Operation> getAllHistoricTransactions(String accountNumber);
	
	
	/**
     * Method to print all historic operations
     * @return void
     */
	ByteArrayInputStream  printHistoricTransactions(String accountNumber) throws Exception;
}
