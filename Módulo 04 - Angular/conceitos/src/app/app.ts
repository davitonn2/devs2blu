import { Component, signal } from '@angular/core';
import { PrimeiroComponente } from "./primeiro-componente/primeiro-componente";
import { DataBindings } from "./data-bindings/data-bindings";
import { Formulario } from "./formulario/formulario";
import { ControleServer } from "./controle-server/controle-server";
import { Diretivas } from "./diretivas/diretivas";

@Component({
  selector: 'app-root',
  imports: [Diretivas],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('conceitos');
}
