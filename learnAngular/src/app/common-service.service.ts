import { Injectable } from '@angular/core';
import { CamelCasePipe } from './camel-case.pipe';
import { SnakeCasePipe } from './snake-case.pipe';
import { TitleCasePipe } from './title-case.pipe';

@Injectable({
  providedIn: 'root',
})
export class CommonServiceService {
  sentence: string = '';
  dataArray : string[]= [];

  constructor(
    private camelCasePipe: CamelCasePipe,
    private snakeCasePipe: SnakeCasePipe,
    private titleCasePipe: TitleCasePipe  ) { }
  
  add( num1: number , num2 : number ){
    return num1 + num2;
  }

  camelCase(word: string){
    return this.camelCasePipe.transform(word);
  }

  snakeCase(word: string){
    return this.snakeCasePipe.transform(word);
  }

  toLowerCase(text: string): string {
    return text ? text.toLowerCase() : '';
  }

  toUpperCase(text: string): string {
    return text ? text.toUpperCase() : '';
  }

  titleCase(text: string): string{
    return this.titleCasePipe.transform(text);
  }

  setData(text: string){
    this.dataArray.push(text)
  }

  getData(){
    return this.dataArray
  }
}
