import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Evento } from './evento'; // Asegúrate de importar la clase Evento adecuada
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class EventoService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getEventos(): Observable<Evento[]> {
    return this.http.get<Evento[]>(`${this.apiServerUrl}/evento/all`);
  }

  public addEvento(evento: Evento): Observable<Evento> {
    return this.http.post<Evento>(`${this.apiServerUrl}/evento/add`, evento);
  }

  public updateEvento(evento: Evento): Observable<Evento> {
    return this.http.put<Evento>(`${this.apiServerUrl}/evento/update`, evento);
  }

  public deleteEvento(eventoId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/evento/delete/${eventoId}`);
  }
}
