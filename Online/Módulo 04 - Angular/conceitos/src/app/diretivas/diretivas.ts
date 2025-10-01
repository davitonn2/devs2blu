import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { EventoMouse } from '../minha-diretiva/evento-mouse';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-diretivas',
  imports: [CommonModule, EventoMouse, FormsModule],
  templateUrl: './diretivas.html',
  styleUrl: './diretivas.css'
})
export class Diretivas {
  //Vetor contendo a situaçao de cada aluno na escola
  alunos:string[] = ['aprovado', 'aprovado', 'reprovado', 'aprovado'];




  // Variáveis
  corFonte:string = 'yellow';
  corFundo:string = 'green';

  //Objet
  estilo = {
    'color': this.corFonte,
    'background-color': this.corFundo
  };

  // Funções para alterar as propiedades css
  alterarEstilo():void{
    this.corFonte = this.corFonte === 'yellow' ? 'blue' : 'yellow';
    this.corFundo = this.corFundo === 'green' ? 'red' : 'green';

    this.estilo = {
    'color': this.corFonte,
    'background-color': this.corFundo
  };
  }
  //Exercicio, variaveis e funcoes para calcular a media de 3 notas
  nota1: number = 0;
  nota2: number = 0;
  nota3: number = 0;
  media: number | null = null;
  situacao: string = '';

  aprovados: number = 0;
  reprovados: number = 0;

  calcularMedia() {
    if (
      this.nota1 >= 0 && this.nota1 <= 10 &&
      this.nota2 >= 0 && this.nota2 <= 10 &&
      this.nota3 >= 0 && this.nota3 <= 10
    ) {
      this.media = (this.nota1 + this.nota2 + this.nota3) / 3;

      if (this.media >= 7) {
        this.situacao = 'Aprovado';
        this.aprovados++;
      } else {
        this.situacao = 'Reprovado';
        this.reprovados++;
      }
    } else {
      alert('Informe notas entre 0 e 10!');
    }
  }

  // Exercicio 02
  
  valorReal: number = 0;
  moeda: string = '';
  resultado: number | null = null;

  // Cotações fictícias (para exemplo)
  cotacoes: { [key: string]: number } = {
    'Bitcoin': 0.0000069, // 1 real = X BTC
    'Dólar': 0.18,
    'Euro': 0.16,
    'Ethereum': 0.00013,
    'Libra': 0.14,
    'Iene': 28.43
  };

  converter() {
    if (this.moeda && this.valorReal > 0) {
      this.resultado = this.valorReal * this.cotacoes[this.moeda];
    } else {
      alert('Informe o valor em reais e selecione a moeda!');
    }
  }
}
