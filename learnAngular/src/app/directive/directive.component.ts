import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CamelCasePipe } from '../camel-case.pipe';
import { SnakeCasePipe } from '../snake-case.pipe';

@Component({
  selector: 'app-directive',
  standalone: false,
  templateUrl: './directive.component.html',
  styleUrl: './directive.component.css',
  providers: [CamelCasePipe, SnakeCasePipe]
})
export class DirectiveComponent {

  userInput: string = '';
  transformedText: string = '';
  showTransformed = false;
  transformedWord: string = '';

  constructor(private camelCasePipe: CamelCasePipe,
    private snakeCasePipe: SnakeCasePipe
  ) {} // Inject Pipe

  transformText() {
    this.transformedText = this.camelCasePipe.transform(this.userInput);
    this.transformedWord = this.snakeCasePipe.transform(this.userInput);
    this.showTransformed = true;
  }
}
