import { Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'camelCase',
  standalone: false
})

@Injectable({ providedIn: 'root' })
export class CamelCasePipe implements PipeTransform {

  transform(value: string): string {
    return value.toLowerCase()
    .replace(/(?:^\w|[A-Z]|\b\w)/g, (match, index) => 
      index === 0 ? match.toLowerCase() : match.toUpperCase()
    ).replace(/\s+/g, '');
  }

}
