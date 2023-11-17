import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Alquiler } from './alquiler'; // Asegúrate de importar la clase Alquiler adecuada
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class AlquilerService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getAlquileres(): Observable<Alquiler[]> {
    return this.http.get<Alquiler[]>(`${this.apiServerUrl}/alquiler/all`);
  }

  public addAlquiler(alquiler: Alquiler): Observable<Alquiler> {
    return this.http.post<Alquiler>(`${this.apiServerUrl}/alquiler/add`, alquiler);
  }

  public updateAlquiler(alquiler: Alquiler): Observable<Alquiler> {
    return this.http.put<Alquiler>(`${this.apiServerUrl}/alquiler/update`, alquiler);
  }

  public deleteAlquiler(alquilerId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/alquiler/delete/${alquilerId}`);
  }
}
