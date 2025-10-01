import { Component } from '@angular/core';

@Component({
  selector: 'app-controle-server',
  imports: [],
  templateUrl: './controle-server.html',
  styleUrl: './controle-server.css'
})
export class ControleServer {
  media:number = 8;
  linguagem:string = 'Java';
  nomes:string[] = ['João', 'Maria', 'José'];
}
