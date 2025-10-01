import { Component } from '@angular/core';

@Component({
  selector: 'app-data-bindings',
  imports: [],
  templateUrl: './data-bindings.html',
  styleUrl: './data-bindings.css'
})
export class DataBindings {
  //Imagem
  imagem:string = 'dia.jpg';

  // Funcao para alterar a imagem
  funcao():void{
    // 1 maneira
    if(this.imagem === 'arima.webp') {
      this.imagem = 'depois.png'
    } else {
      this.imagem = 'arima.webp'
    }

    // 2 maneira
    //this.imagem = this.imagem === 'arima.webp' ? 'depois.png': 'arima.webp';
  }
}
