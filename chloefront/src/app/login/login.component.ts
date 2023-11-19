import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Login } from './login';
import { AuthResponse } from './AuthResponse';

@Component({
  selector: 'app-loguin',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  usuarioForm: FormGroup;
  usuario: Login; // Declarar usuario como una propiedad del componente
  nombreusuario: string;
  clave: string;

  constructor(
    private authService: AuthService,
    private router: Router,
    private formBuilder: FormBuilder
  ) {
    this.usuarioForm = this.formBuilder.group({
      nombreUsuario: ['', Validators.required],
      clave: ['', Validators.required]
    });
  }

  login(): void {
    this.usuario = new Login(this.nombreusuario, this.clave);
    console.log('Credenciales enviadas:', this.usuario);

    this.authService.login(this.usuario).subscribe(
        (response: AuthResponse) => {
            console.log('Respuesta del servidor:', response);

            if (response.success) {
                this.iradministracion();
                alert(response.message);
            } else {
                alert('Error: ' + response.message);
                // Puedes agregar más lógica según sea necesario, como mostrar un mensaje de error en el formulario.
            }
        },
        (error) => {
            console.error('Error en la autenticación:', error);
            alert('Error: Credenciales incorrectas');
            this.router.navigate(['/login']);
        }
    );
}

  iradministracion() {
    this.router.navigate(['/vestido']);
  }
}
