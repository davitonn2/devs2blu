import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class Auth {
  private readonly USER_KEY = 'currentUser';

  constructor(private router: Router) { }

  register(user: any): boolean {
    let users = JSON.parse(localStorage.getItem('users') || '[]');
    if (users.find((u: any) => u.email === user.email)) {
      alert('Este e-mail já está cadastrado.');
      return false;
    }
    users.push(user);
    localStorage.setItem('users', JSON.stringify(users));
    return true;
  }

  login(credentials: any): boolean {
    let users = JSON.parse(localStorage.getItem('users') || '[]');
    const user = users.find((u: any) => u.email === credentials.email && u.senha === credentials.senha);
    if (user) {
      localStorage.setItem(this.USER_KEY, JSON.stringify(user));
      return true;
    }
    alert('E-mail ou senha inválidos.');
    return false;
  }

  logout(): void {
    localStorage.removeItem(this.USER_KEY);
    this.router.navigate(['/login']);
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem(this.USER_KEY);
  }

  getCurrentUser(): any | null {
    const user = localStorage.getItem(this.USER_KEY);
    return user ? JSON.parse(user) : null;
  }
}
