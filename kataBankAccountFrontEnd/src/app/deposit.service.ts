import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DepositService{
	
 constructor(private http:HttpClient) {}

 accountNumber:string;
 amount:number;
 
 private API="http://localhost:8043/deposit";

 public deposit(accountNumber,amount){
    let params = "accountNumber="+accountNumber+"&amount="+amount;
    return this.http.post(this.API,params);
 }
}