import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs'

export class LoginService {
    private apiUrl = 'http://localhost:8080/auth';  // Cambia la URL según tu backend
  
    constructor(private http: HttpClient) { }
  
    login(nombreusuario: string, clave: string): Observable<string> {
      const credentials = { nombreusuario ,  clave };
      return this.http.post<string>(`${this.apiUrl}/login`, credentials);
    }
  
}