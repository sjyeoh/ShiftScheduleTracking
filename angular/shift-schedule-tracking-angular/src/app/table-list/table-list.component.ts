import { Component, OnInit } from '@angular/core';
import { UserService } from '../user-service.service';
import { DatePipe } from '@angular/common';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';

@Component({
  selector: 'app-table-list',
  templateUrl: './table-list.component.html',
  styleUrls: ['./table-list.component.css'],
  providers: [DatePipe]
})
export class TableListComponent implements OnInit {
  DisplayUser = new FormGroup({
    name: new FormControl("")
  })
  users: any[] = [];
  userrecord: any[] = [];

  selectedValue: number;

  constructor(private userService: UserService, private datePipe: DatePipe) { }

  ngOnInit() {
    this.userService.getUser().subscribe((users) => {
      this.users = users as any[]
    })
    this.showAllRecord()
  }

  showUserRecord(){
    const formValues = this.DisplayUser.value
    this.userService.getRecordByUser(this.selectedValue).subscribe((userrecord)=>{this.userrecord=userrecord as any[]})
    console.log(this.userrecord)
  }

  showAllRecord(){
    this.userService.getAllRecord().subscribe((userrecord)=>{this.userrecord=userrecord as any[]})
    console.log(this.userrecord)
  }
}
