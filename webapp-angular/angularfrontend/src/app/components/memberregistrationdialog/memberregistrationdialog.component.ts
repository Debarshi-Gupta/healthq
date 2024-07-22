import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Router } from '@angular/router';

@Component({
  selector: 'app-memberregistrationdialog',
  templateUrl: './memberregistrationdialog.component.html',
  styleUrls: ['./memberregistrationdialog.component.css']
})
export class MemberregistrationdialogComponent implements OnInit {

  constructor(public dialogRef:MatDialogRef<MemberregistrationdialogComponent>, @Inject(MAT_DIALOG_DATA) public data:any, private router:Router) { }

  ngOnInit(): void {
  }

  backHome()
  {
    this.router.navigate(['home']);
    this.dialogRef.close();
  }

}
