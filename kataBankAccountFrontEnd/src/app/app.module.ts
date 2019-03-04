import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { OperationService } from './operation.service';
import { DepositService } from './deposit.service';
import { WithdrawService } from './withdraw.service';

import { HttpClient,HttpClientModule  } from '@angular/common/http';


import { AppComponent } from './app.component';
import { OperationComponent } from './operations.component';
import { DepositAmoutComponent} from './depositAmount.component';
import { WithDrawAmoutComponent} from './withDrawAmount.component';

const routes: Routes = [
  { path: 'operations', component: OperationComponent },
  { path: 'deposit', component: DepositAmoutComponent },
  { path: 'withdraw', component: WithDrawAmoutComponent }
];

@NgModule({
  declarations: [
    AppComponent,
                 OperationComponent,
                 DepositAmoutComponent,
                 WithDrawAmoutComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [OperationService],
  bootstrap: [AppComponent]
})


export class AppModule { }
