import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'media'
})
export class MediaPipe implements PipeTransform {

  transform(notas: number[]): number {
    if (!notas || notas.length === 0) {
      return 0;
    }
    const soma = notas.reduce((acc, nota) => acc + nota, 0);
    const media = soma / notas.length;
    return parseFloat(media.toFixed(2));
  }

}
