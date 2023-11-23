import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vestido } from './vestido';
import { environment } from 'src/environments/environment';
import * as $ from 'jquery';

@Injectable({ providedIn: 'root' })// La anotación @Injectable indica que este servicio se proporciona a sí mismo a nivel de toda la aplicación ('root'), lo que significa que estará disponible para toda la aplicación Angular.
export class VestidoService {
  // URL base de la API obtenida del archivo de entorno
  private apiServerUrl = environment.apiBaseUrl;
  // Constructor que inyecta el servicio HttpClient
  constructor(private http: HttpClient) { }
  // Método para obtener todos los vestidos desde la API
  public getVestidos(): Observable<Vestido[]> {
    return this.http.get<Vestido[]>(`${this.apiServerUrl}/vestido/all`);
  }
  // Método para agregar un nuevo vestido a la API
  public addVestido(vestido: Vestido): Observable<Vestido> {
    return this.http.post<Vestido>(`${this.apiServerUrl}/vestido/add`, vestido);
  }
  // Método para actualizar un vestido existente en la API
  public updateVestido(vestido: Vestido): Observable<Vestido> {
    return this.http.put<Vestido>(`${this.apiServerUrl}/vestido/update`, vestido);
  }
  // Método para eliminar un vestido de la API por su ID
  public deleteVestido(vestidoId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/vestido/delete/${vestidoId}`);
  }
  // Método para buscar vestidos en la API por una clave de búsqueda
  public searchVestidos(key: string): Observable<Vestido[]> {
    return this.http.get<Vestido[]>(`${this.apiServerUrl}/vestido/search?key=${key}`);
  }

  // VestidoService

public searchVestidosByTalle(talle: string): Observable<Vestido[]> {
  return this.http.get<Vestido[]>(`${this.apiServerUrl}/vestido/searchByTalle?Talle=${talle}`);
}


}

//Cada método utiliza el servicio HttpClient para realizar operaciones HTTP como GET, POST, PUT y DELETE en la API del servidor. Estos métodos devuelven Observables que pueden ser suscritos desde componentes Angular para manejar los resultados de las solicitudes HTTP.