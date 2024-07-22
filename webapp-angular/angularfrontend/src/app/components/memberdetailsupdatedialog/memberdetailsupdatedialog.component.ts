import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-memberdetailsupdatedialog',
  templateUrl: './memberdetailsupdatedialog.component.html',
  styleUrls: ['./memberdetailsupdatedialog.component.css']
})
export class MemberdetailsupdatedialogComponent implements OnInit {

  constructor(public dialogRef:MatDialogRef<MemberdetailsupdatedialogComponent>, @Inject(MAT_DIALOG_DATA) public data:any, private router:Router) { }

  ngOnInit(): void {
  }

  backHome()
  {
    this.router.navigate(['home']);
    this.dialogRef.close();
  }

}
