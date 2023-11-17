import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import * as $ from 'jquery';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VestidoComponent } from './vestido/vestido.component';
import { PrecioComponent } from './precio/precio.component';
import { ClienteComponent } from './cliente/cliente.component';
import { AlquilerComponent } from './alquiler/alquiler.component';
import { EventoComponent } from './evento/evento.component';
import { FormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AppService } from './app.service';
import { VistaPrincipalComponent } from './vista-principal/vista-principal.component';
import { LoginComponent } from './login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    VestidoComponent,
    PrecioComponent,
    ClienteComponent,
    AlquilerComponent,
    EventoComponent,
    VistaPrincipalComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [AppService],
  bootstrap: [AppComponent]
})
export class AppModule { }
