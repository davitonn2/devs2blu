import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AlunoForm } from './components/aluno-form/aluno-form';
import { MediaPipe } from './pipes/media-pipe';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AlunoForm, MediaPipe],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('sistema-notas');
}

export class AppComponent {
  title = 'sistema-notas';
}