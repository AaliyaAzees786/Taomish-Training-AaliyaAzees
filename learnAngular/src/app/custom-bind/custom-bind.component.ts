import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-custom-bind',
  standalone: false,
  templateUrl: './custom-bind.component.html',
  styleUrl: './custom-bind.component.css'
})
export class CustomBindComponent {
  @Input() message = "";
  
    @Output()  sendMessageFromChild = new EventEmitter<{}>();
    
    onClick(){
      this.sendMessageFromChild.emit("message from child");
    }
}
