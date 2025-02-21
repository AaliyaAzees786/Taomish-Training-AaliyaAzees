import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { GridComponent } from './grid/grid.component';
import { FlexComponent } from './flex/flex.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, GridComponent, FlexComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'first_project';
}
