import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  standalone: false,
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'taomish';

  message =""


  getChildMessage(event: any){
    this.message = event

  }
  
}
