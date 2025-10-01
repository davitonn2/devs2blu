import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { MediaPipe } from '../../pipes/media-pipe';
import { CommonModule } from '@angular/common';

interface Aluno {
  nome: string;
  nota1: number;
  nota2: number;
}

@Component({
  selector: 'app-aluno-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MediaPipe],
  templateUrl: './aluno-form.html',
  styleUrls: ['./aluno-form.css']
})

export class AlunoForm implements OnInit {
  alunoForm!: FormGroup
  alunos: Aluno[] = [];

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
    this.alunoForm = this.fb.group({
      nome: ['', Validators.required],
      nota1: ['', [Validators.required, Validators.min(0), Validators.max(10)]],
      nota2: ['', [Validators.required, Validators.min(0), Validators.max(10)]]
    });
  }

  adicionarAluno(): void {
    if (this.alunoForm && this.alunoForm.valid) {
      this.alunos.push(this.alunoForm.value as Aluno);
      this.alunoForm.reset();
    } else {
      alert('Por favor, preencha todos os campos corretamente.');
    }
  }
}
