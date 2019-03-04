package com.dal;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.entites.Operation;

/**
 * DAO interface which defines {@link OperationDAL} to service layer.
 *
 * The informations about all Operation is retrieved by this method :
 * {@link OperationDAL#getAllOperations()} Those criteria should define all Operation.
 */

public interface OperationDAL extends JpaRepository<Operation,String>{
 @Query("select op.operationType,op.operationDate,op.amount,op.account.accountBalance from Operation op where op.account.accountNumber=: accountNumber order by op.operationDate desc")
 Collection<Operation> getAllOperations(@Param("accountNumber")String accountNumber);
}
