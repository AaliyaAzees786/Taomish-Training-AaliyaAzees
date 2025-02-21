import { Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'titleCase',
  standalone: false
})

@Injectable({
  providedIn: 'root'
})
export class TitleCasePipe implements PipeTransform {

  transform(value: string): string {
    return value.toLowerCase().split(' ').map(word => word.charAt(0).toUpperCase() + word.slice(1)).join(' ');
  }

}
