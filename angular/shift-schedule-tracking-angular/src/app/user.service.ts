import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const BASE_URL = "http://localhost:8080"

@Injectable({
  providedIn: 'root',
})
export class UserService {

  constructor(private http: HttpClient) { }

  currentDate = new Date();

  
  getUser(){
    return this.http.get(`${BASE_URL}/user/`)
  }

  insertRecord(createdAt,createdBy,updatedAt,updatedBy,updateFrequency,user_id,leaveType,applyDate){
    const params = {
      createdAt: createdAt,
      createdBy: createdBy,
      updatedAt: updatedAt,
      updatedBy: updatedBy,
      updateFrequency: updateFrequency,
      user_id: user_id,
      leaveType: leaveType,
      applyDate: applyDate
    }

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':'application/json',
      }),
    }

    return this.http.post(`${BASE_URL}/userrecord/`,params, httpOptions)
  }
}