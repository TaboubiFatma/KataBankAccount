import { Component } from '@angular/core';
import { Operation } from './operation.model';
import { OperationService } from './operation.service';

@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html'
  })
export class OperationComponent {
  
  accountNumber:string;
  operations:Operation[];

  constructor(private operationService:OperationService){}

  getAllOperation(accountNumber): void {
    this.operationService.getHistoriqOperations(accountNumber)
      .subscribe( data => {
        this.operations = data;
      })
  };


  printAllOperation(accountNumber): void {
    this.operationService.printHistoricOperations(accountNumber).subscribe()
  };

}