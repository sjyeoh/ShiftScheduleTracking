import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

const BASE_URL = "http://localhost:8080"

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  currentDate = new Date();

  public message: any;

  getUser() {
    return this.http.get(`${BASE_URL}/user/`)
  }

  getRecordByUser(userId) {
    return this.http.get(`${BASE_URL}/userrecords?id=${userId}`)
  }

  getAllRecord(){
    return this.http.get(`${BASE_URL}/userrecords`)
  }
  // insertRecord(createdAt,createdBy,updatedAt,updatedBy,updateFrequency,user_id,leaveType,applyDate){
  //   const params = {
  //     createdAt: createdAt,
  //     createdBy: createdBy,
  //     updatedAt: updatedAt,
  //     updatedBy: updatedBy,
  //     updateFrequency: updateFrequency,
  //     user_id: user_id,
  //     leaveType: leaveType,
  //     applyDate: applyDate
  //   }

  insertRecord(user_id, leaveType, applyDate) {
    const params = {
      user_id: user_id,
      leaveType: leaveType,
      applyDate: applyDate
    }

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    }

     return this.http.post(`${BASE_URL}/userrecord/`,params, httpOptions)
    // this.http.post(`${BASE_URL}/userrecord/`, params, httpOptions).subscribe((res: HttpResponse<any>) => {
    //   console.log(res.headers.get('status'));
    //   this.message = res.headers.get('status');
    //   return this.message;
    // })
    
  }
}
