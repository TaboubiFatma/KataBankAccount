package com.controllers;

import java.util.Collection;
import org.springframework.core.io.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.entites.Operation;
import com.service.OperationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/operations")
public class OperationController {

	@Autowired
	private OperationService operationService ;

	@RequestMapping(value="/history/{accountNumber}",method=RequestMethod.GET)
	public Collection<Operation> getAllOperations(@PathVariable("accountNumber") String accountNumber){
		return operationService.getAllHistoricTransactions(accountNumber);
	}
	
	@RequestMapping(value="/history/print/{accountNumber}",method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> printHistoricOperation(@PathVariable("accountNumber") String accountNumber) throws Exception{
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","inline;filename=AccountStatement.pdf");
		return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(operationService.printHistoricTransactions(accountNumber)));
	}
	public OperationService getOperationService() {
		return operationService;
	}

	public void setOperationService(OperationService operationService) {
		this.operationService = operationService;
	} 
}
