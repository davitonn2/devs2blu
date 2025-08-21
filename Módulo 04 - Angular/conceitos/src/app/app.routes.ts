import { Routes } from '@angular/router';
import { Pagina01 } from './paginas/pagina01/pagina01';
import { Pagina03 } from './paginas/pagina03/pagina03';
import { Pagina02 } from './paginas/pagina02/pagina02';
import { PaginaNaoEncontrada } from './paginas/pagina-nao-encontrada/pagina-nao-encontrada';

export const routes: Routes = [
    {path:'pagina01', component:Pagina01},
    {path:'pagina02', component:Pagina02},
    {path:'pagina03', component:Pagina03},
    {path:'', redirectTo:'pagina01', pathMatch:'full'},
    {path:'**', component:PaginaNaoEncontrada}
];
