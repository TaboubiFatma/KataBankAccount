package com.service.impl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dal.OperationDAL;
import com.entites.Operation;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationDAL operationDAL ; 
	
    
	@Override
	public Collection<Operation> getAllHistoricTransactions(String accountNumber) {
		return operationDAL.getAllOperations(accountNumber);
	}

	public OperationDAL getOperationDAL() {
		return operationDAL;
	}

	public void setOperationDAL(OperationDAL operationDAL) {
		this.operationDAL = operationDAL;
	}

	@Override
	public ByteArrayInputStream  printHistoricTransactions(String accountNumber) throws Exception {
		
		//Create document to print
		Document accountStatementDocument = new Document();
		ByteArrayOutputStream outDocumentGenerated = new ByteArrayOutputStream();
		PdfPCell operationCell;
		
        PdfWriter writer = PdfWriter.getInstance(accountStatementDocument, outDocumentGenerated);
        accountStatementDocument.open();
        
        // fill data in the document
        accountStatementDocument.add( new Paragraph("Account Statment                                                                                               Date : "+new SimpleDateFormat("dd/MM/YYYY").format(new Date())));
        accountStatementDocument.add(new LineSeparator());
        accountStatementDocument.add(new Paragraph("Account Number : "+accountNumber));

        PdfPTable operationsTable = new PdfPTable(4);
        operationsTable.setWidthPercentage(100);
        operationsTable.setSpacingBefore(20f);
        operationsTable.setSpacingAfter(50f);
        operationsTable.setWidths(new int[]{10, 10, 10,10});

        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

           
        operationCell = new PdfPCell(new Phrase("Operation", headFont));
        operationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        operationsTable.addCell(operationCell);

        operationCell = new PdfPCell(new Phrase("Date", headFont));
        operationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        operationsTable.addCell(operationCell);

        operationCell = new PdfPCell(new Phrase("Amount", headFont));
        operationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        operationsTable.addCell(operationCell);
           
        operationCell = new PdfPCell(new Phrase("Balance", headFont));
        operationCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        operationsTable.addCell(operationCell);
           
           
        for (Operation operation : getAllHistoricTransactions(accountNumber)) {

               PdfPCell operationCellDefinition;

               operationCellDefinition = new PdfPCell(new Phrase(operation.getOperationType()));
               operationCellDefinition.setVerticalAlignment(Element.ALIGN_MIDDLE);
               operationCellDefinition.setHorizontalAlignment(Element.ALIGN_CENTER);
               operationsTable.addCell(operationCellDefinition);

               operationCellDefinition = new PdfPCell(new Phrase(new SimpleDateFormat("dd/MM/YYYY").format(operation.getOperationDate())));
               operationCellDefinition.setPaddingLeft(5);
               operationCellDefinition.setVerticalAlignment(Element.ALIGN_MIDDLE);
               operationCellDefinition.setHorizontalAlignment(Element.ALIGN_LEFT);
               operationsTable.addCell(operationCellDefinition);

               operationCellDefinition = new PdfPCell(new Phrase(String.valueOf(operation.getAmount())));
               operationCellDefinition.setVerticalAlignment(Element.ALIGN_MIDDLE);
               operationCellDefinition.setHorizontalAlignment(Element.ALIGN_RIGHT);
               operationCellDefinition.setPaddingRight(5);
               operationsTable.addCell(operationCellDefinition);
               
               
               operationCellDefinition = new PdfPCell(new Phrase(String.valueOf(operation.getAccount().getAccountBalance())));
               operationCellDefinition.setVerticalAlignment(Element.ALIGN_MIDDLE);
               operationCellDefinition.setHorizontalAlignment(Element.ALIGN_RIGHT);
               operationCellDefinition.setPaddingRight(5);
               operationsTable.addCell(operationCellDefinition);
           }
           accountStatementDocument.add(operationsTable);
           accountStatementDocument.close();
           writer.close();
    	return new ByteArrayInputStream(outDocumentGenerated.toByteArray());
	}
}
