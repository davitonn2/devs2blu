import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { Auth } from '../services/auth';

export const authGuard: CanActivateFn = (route, state) => {
  const auth = inject(Auth);
  const router = inject(Router);

  if (auth.isLoggedIn()) {
    return true; // Usuário logado, pode acessar a rota
  }

  // Usuário não logado, redireciona para a página de login
  router.navigate(['/login']);
  return false;
};
