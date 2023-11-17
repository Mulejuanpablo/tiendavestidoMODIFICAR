import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Precio } from './precio'; // Asegúrate de importar la clase Precio adecuada
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class PrecioService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getPrecios(): Observable<Precio[]> {
    return this.http.get<Precio[]>(`${this.apiServerUrl}/precio/all`);
  }

  public addPrecio(precio: Precio): Observable<Precio> {
    return this.http.post<Precio>(`${this.apiServerUrl}/precio/add`, precio);
  }

  public updatePrecio(precio: Precio): Observable<Precio> {
    return this.http.put<Precio>(`${this.apiServerUrl}/precio/update`, precio);
  }

  public deletePrecio(precioId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/precio/delete/${precioId}`);
  }
}
