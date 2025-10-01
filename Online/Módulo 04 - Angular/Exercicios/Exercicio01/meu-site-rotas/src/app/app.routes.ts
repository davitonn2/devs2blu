import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Importe seus componentes aqui
import { Home } from './pages/home/home';
import { Contato } from './pages/contato/contato';
import { Sobre } from './pages/sobre/sobre';
import { NotFound } from './pages/not-found/not-found';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component:Home },
  { path: 'contato', component:Contato },
  { path: 'sobre', component:Sobre },
  { path: '**', component: NotFound }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }