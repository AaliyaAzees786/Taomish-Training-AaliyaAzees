import { AfterViewInit, Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators} from '@angular/forms'
import { CommonServiceService } from '../common-service.service';

@Component({
  selector: 'app-form',
  standalone: false,
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit , AfterViewInit{
  sum: number = 0;
  ngAfterViewInit(): void {
    console.log("view initilized")
  }

  ngOnInit() {
    console.log("checking")
  }

  constructor( private commonService : CommonServiceService){

  }

  

  @ViewChild('input') inputValue !: ElementRef;

  message = ""

  userForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.minLength(3)]),
      age: new FormControl('', [Validators.required, Validators.min(18)]),
      dateofbirth: new FormControl('',[Validators.required]),
      role: new FormControl(''),
      address: new FormGroup({
        street: new FormControl(''),
        city: new FormControl(''),
        pincode: new FormControl('')
      })
  });
  canVote: string = '';
  age: number = 0;

  onclick(){
    console.log(this.userForm);
    this.userForm.reset();
  }

  checkVotingEligibility() {
    this.canVote = this.age >= 18 ? 'Able to vote' : 'Not able to vote';
  }

  onClick(){
    // this.message = message;
    // console.log(this.inputValue)
    this.sum = this.commonService.add(2, 5);
  }

}
