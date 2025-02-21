import { Routes } from '@angular/router';
import { Template1Component } from './template1/template1.component';
import { Template2Component } from './template2/template2.component';

export const routes: Routes = [
    { path: 'template1', component: Template1Component },
    { path: 'template2', component: Template2Component },
];
