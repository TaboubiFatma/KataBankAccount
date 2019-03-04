import { Component } from '@angular/core';
import { WithdrawService } from './withdraw.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withDrawAmount.component.html'
  })
export class WithDrawAmoutComponent {
   accountNumber:string;
  amount:number;

  constructor(private withdrawService:WithdrawService){}

  withdrawTransaction(accountNumber,amount): void {
    this.withdrawService.withdraw(accountNumber,amount).subscribe()
  };
}