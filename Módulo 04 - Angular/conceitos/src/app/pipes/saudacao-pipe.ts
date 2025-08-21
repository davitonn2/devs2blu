import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'saudacao'
})
export class SaudacaoPipe implements PipeTransform {

  transform(nome:string): string {
    return 'Óla, ' + nome + '!';
  }

}
