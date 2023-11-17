import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as $ from 'jquery';

@Injectable({
  providedIn: 'root'
})

export class AppService {

  constructor() { }
}
export class VestidoService {
  constructor(private http: HttpClient) {
    // ...
  }

  // Resto del servicio
}



