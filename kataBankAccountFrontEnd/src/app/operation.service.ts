import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Operation } from './operation.model';

@Injectable()
export class OperationService{
	
 constructor(private http:HttpClient) {}

 accountNumber:string;
 private API="http://localhost:8043/operations/history";

 public getHistoriqOperations(accountNumber){
    return this.http.get<Operation[]>(this.API+"/"+accountNumber);
 }

 public printHistoricOperations(accountNumber){
   return this.http.get(this.API+"/print/"+accountNumber);
 }

}