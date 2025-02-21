import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormComponent } from './form/form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeComponent } from './employee/employee.component';
import { TodoComponent } from './todo/todo.component';
import { CustomBindComponent } from './custom-bind/custom-bind.component';
import { ButtonDirective } from './button.directive';
import { DirectiveComponent } from './directive/directive.component';
import { TooltipDirective } from './tooltip.directive';
import { CamelCasePipe } from './camel-case.pipe';
import { SnakeCasePipe } from './snake-case.pipe';
import { CasingComponent } from './casing/casing.component';
import { TitleCasePipe } from './title-case.pipe';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent,
    EmployeeComponent,
    TodoComponent,
    CustomBindComponent,
    ButtonDirective,
    DirectiveComponent,
    TooltipDirective,
    CamelCasePipe,
    SnakeCasePipe,
    CasingComponent,
    TitleCasePipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    provideClientHydration(withEventReplay())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
