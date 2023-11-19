import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Login } from './login';
import { AuthResponse } from './AuthResponse';
@Injectable({
    providedIn: 'root'
})
export class AuthService {
    private apiServerUrl = environment.apiBaseUrl;

    constructor(private http: HttpClient) {}

    login(usuario: Login): Observable<AuthResponse> {
        return this.http.post<AuthResponse>(`${this.apiServerUrl}/auth/login`, usuario);
    }

    registro(usuario: any): Observable<any> {
        return this.http.post(`${this.apiServerUrl}/auth/registro`, usuario);
    }
}
