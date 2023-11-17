import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Router } from '@angular/router';

// Importa los componentes que deseas mostrar en las rutas.
import { VestidoComponent } from './vestido/vestido.component';
import { VistaPrincipalComponent } from './vista-principal/vista-principal.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  // Ruta para la página de administración de vestidos
  {path: '', component: VistaPrincipalComponent,},
  {path: 'loguin', component: LoginComponent},
  { path: 'vestido', component: VestidoComponent }
 // { path: 'administrar-vestidos', component: VestidoComponent },
  // Otras rutas pueden ir aquí
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
