import { Injectable, Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'snakeCase',
  standalone: false
})

@Injectable({ providedIn: 'root' })
export class SnakeCasePipe implements PipeTransform {

  transform(value: string): string {
    return value.toLowerCase().replace(/ /g,'_');
  }

}
