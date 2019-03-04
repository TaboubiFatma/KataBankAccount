import { Component } from '@angular/core';
import { DepositService } from './deposit.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './depositAmount.component.html'
  })
export class DepositAmoutComponent {
  accountNumber:string;
  amount:number;

  constructor(private depositService:DepositService){}

  depositTransaction(accountNumber,amount): void {
    this.depositService.deposit(accountNumber,amount).subscribe()
  };
}