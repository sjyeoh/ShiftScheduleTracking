import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { DatePipe} from '@angular/common'

@Component({
  selector: 'app-insert-form',
  templateUrl: './insert-form.component.html',
  styleUrls: ['./insert-form.component.css'],
  providers: [ DatePipe ] 
})
export class InsertFormComponent implements OnInit {
  @Input() displayInsertForm;
  insertForm = new FormGroup({
    name: new FormControl(""),
    leave: new FormControl(""),
    dateApply: new FormControl(""),
  })

  users: any[] = [];
  createdAt : Date = new Date();
  createdBy : String = "SystemAdmin";
  updatedAt : Date = new Date();
  updatedBy : String = "SystemAdmin";
  updateFrequency : Number = 1;

  constructor(private userService: UserService,private datePipe: DatePipe) { }
  
  ngOnInit() {
    this.userService.getUser().subscribe((users) => {
      this.users = users as any[]
    })

  }

  onSubmit() {
    // console.log(this.insertForm.value)
    // console.log(this.insertForm.controls)
    // debugger
    const formValues = this.insertForm.value
    // check date value format pass to db
    // console.log(this.datePipe.transform(this.createdAt,'yyyy-MM-dd'))
    // console.log(this.createdBy)

    // main function call
    this.userService.insertRecord(
      this.datePipe.transform(this.createdAt,'yyyy-MM-dd'),
      this.createdBy,
      this.datePipe.transform(this.updatedAt,'yyyy-MM-dd'),
      this.updatedBy,
      this.updateFrequency,
      formValues.name,
      formValues.leave,
      this.datePipe.transform(formValues.dateApply,'yyyy-MM-dd')
    ).subscribe(response => {
      console.log(response)
    })
  }

}
