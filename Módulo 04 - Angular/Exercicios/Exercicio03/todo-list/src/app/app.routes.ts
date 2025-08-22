import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login';
import { RegisterComponent } from './pages/register/register';
import { TaskListComponent } from './pages/task-list/task-list';
import { authGuard } from './guards/auth-guard'; // Importe a guarda funcional

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  {
    path: 'tasks',
    component: TaskListComponent,
    canActivate: [authGuard] // Aplique a guarda aqui
  },
  { path: '**', redirectTo: 'login' }
];