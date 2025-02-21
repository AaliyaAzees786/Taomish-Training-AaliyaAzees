import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Template1Component } from './template1/template1.component';
import { Template2Component } from './template2/template2.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Template1Component, Template2Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'template_project';
}
