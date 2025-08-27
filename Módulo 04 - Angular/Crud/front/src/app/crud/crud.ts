import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatButton } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { Pessoa } from '../modelo/Pessoa';
import { PessoaApi } from '../servicos/pessoa-api';
import { MatTable, MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-crud',
  imports: [CommonModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatButton, MatTableModule],
  templateUrl: './crud.html',
  styleUrl: './crud.css'
})
export class Crud {

  //Visivilidade dos botões
  btnCadastrar: boolean = true;

  //Objeto do formulario reativo
  formularioPessoa = new FormGroup({
    id:     new FormControl(),
    nome:   new FormControl(),
    cidade: new FormControl(),
  });

  //Colunas da tabela
  colunas: string[] = ['id', 'nome', 'cidade', 'selecionar'];

  // Vetor para armazenar as pessoas
  vetor:Pessoa[] = [];

  // Construtor
  constructor(private servico:PessoaApi) { }

  //ngOnInit
  ngOnInit(): void {
    this.listar();
  }

  //Método para selecionar todas as pessoas
  listar():void {
    this.servico.listar().subscribe(pessoas => this.vetor = pessoas);
  }

  //Método para cadastrar uma pessoa
  cadastrar():void {
    // 1 maneira
    /* const obj = {
      nome:this.formularioPessoa.value.nome,
      cidade:this.formularioPessoa.value.cidade
    } */

    // 2 maneira(Spread operator)
    let obj = {...this.formularioPessoa.value};
    delete obj.id;

    //Realizar o cadastro
    this.servico.cadastrar(obj).subscribe(pessoa => this.vetor = [...this.vetor, pessoa]);

    // Limpar o formulário
    this.formularioPessoa.reset();
  }

  //Método para selecionar uma pessoa especifica
  selecionarPessoa(id:string):void {
  this.servico.selecionarPessoa(id)
  .subscribe(pessoa => {
    // 1 maneira
    /*this.formularioPessoa.get('id')?.setValue(pessoa.id);
    this.formularioPessoa.get('nome')?.setValue(pessoa.nome);
    this.formularioPessoa.get('cidade')?.setValue(pessoa.cidade);*/

    // 2 maneira
    this.formularioPessoa.patchValue(pessoa);

    //Alterar a visibilidade dos botões
    this.btnCadastrar = false;
  });  
  }
  //Metodo para cancelar a edição e remoção
    cancelar():void {
    //Limpar o formulário
    this.formularioPessoa.reset();
    //Alterar a visibilidade dos botões
    this.btnCadastrar = true;
    }
}
