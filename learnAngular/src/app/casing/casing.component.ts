import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CommonServiceService } from '../common-service.service';
import { CamelCasePipe } from '../camel-case.pipe';
import { SnakeCasePipe } from '../snake-case.pipe';
import { TitleCasePipe } from '../title-case.pipe';

@Component({
  selector: 'app-casing',
  standalone: false,
  templateUrl: './casing.component.html',
  styleUrl: './casing.component.css',
})
export class CasingComponent{
    converterForm = new FormGroup({
    inputText: new FormControl('')
  });
  
  array: string[] = [];
  formattedText: string = '';
  
  constructor(private formattingService: CommonServiceService,
    
  ) {}
  
  formatText(formatType: string): void {
    const inputText = this.converterForm.get('inputText')?.value || '';
    
    switch(formatType) {
      case 'titleCase':
        this.formattedText = this.formattingService.titleCase(inputText);
        break;
      case 'camelCase':
        this.formattedText = this.formattingService.camelCase(inputText);
        break;
      case 'lowercase':
        this.formattedText = this.formattingService.toLowerCase(inputText);
        break;
      case 'UPPERCASE':
        this.formattedText = this.formattingService.toUpperCase(inputText);
        break;
      case 'snake_case':
        this.formattedText = this.formattingService.snakeCase(inputText);
        break;
      default:
        this.formattedText = inputText;
    }
  }

  onClick(){
    this.formattingService.setData("Taomish")
  }


  getData(){
    this.array = this.formattingService.getData()
  }

}
