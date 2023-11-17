import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vestido } from './vestido';
import { environment } from 'src/environments/environment';
import * as $ from 'jquery';

@Injectable({ providedIn: 'root' })
export class VestidoService {
 
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getVestidos(): Observable<Vestido[]> {
    return this.http.get<Vestido[]>(`${this.apiServerUrl}/vestido/all`);
  }

  public addVestido(vestido: Vestido): Observable<Vestido> {
    return this.http.post<Vestido>(`${this.apiServerUrl}/vestido/add`, vestido);
  }

  public updateVestido(vestido: Vestido): Observable<Vestido> {
    return this.http.put<Vestido>(`${this.apiServerUrl}/vestido/update`, vestido);
  }

  public deleteVestido(vestidoId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/vestido/delete/${vestidoId}`);
  }
  public searchVestidos(key: string): Observable<Vestido[]> {
    return this.http.get<Vestido[]>(`${this.apiServerUrl}/vestido/search?key=${key}`);
  }
  
}

