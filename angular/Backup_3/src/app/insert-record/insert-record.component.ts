import { Component, OnInit,Input } from '@angular/core';
import { DatePipe} from '@angular/common';

@Component({
  selector: 'app-insert-record',
  templateUrl: './insert-record.component.html',
  styleUrls: ['./insert-record.component.css'],
  providers: [ DatePipe ]
})
export class InsertRecordComponent implements OnInit {

  constructor(private datePipe: DatePipe) { }

  ngOnInit() {
    
  }

}
