import { Component, signal } from '@angular/core';
import { PrimeiroComponente } from "./primeiro-componente/primeiro-componente";
import { DataBindings } from "./data-bindings/data-bindings";
import { Formulario } from "./formulario/formulario";
import { ControleServer } from "./controle-server/controle-server";
import { Diretivas } from "./diretivas/diretivas";
import { ImplementarPipes } from "./implementar-pipes/implementar-pipes";
import { FormularioReativo } from "./formulario-reativo/formulario-reativo";
import { Roteamento } from "./roteamento/roteamento";

@Component({
  selector: 'app-root',
  imports: [ImplementarPipes, FormularioReativo, Roteamento],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('conceitos');
}
