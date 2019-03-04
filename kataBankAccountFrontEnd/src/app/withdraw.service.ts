import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class WithdrawService{
	
 constructor(private http:HttpClient) {}

 accountNumber:string;
 amount:number;
 private API="http://localhost:8043/withdraw";

 public withdraw(accountNumber,amount){
    let params = "accountNumber="+accountNumber+"&amount="+amount;
    return this.http.post(this.API,params);
 }
}