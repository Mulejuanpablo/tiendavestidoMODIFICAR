import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-vista-principal',
  templateUrl: './vista-principal.component.html',
  styleUrls: ['./vista-principal.component.css']
})
export class VistaPrincipalComponent {

  constructor(private router: Router) { }

  iradministracion() {
    this.router.navigate(['login']);
     }
}
