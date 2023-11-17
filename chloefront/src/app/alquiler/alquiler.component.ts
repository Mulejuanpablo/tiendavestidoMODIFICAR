import { Component, OnInit } from '@angular/core';
import { Alquiler } from './alquiler'; // Asegúrate de importar la clase Alquiler adecuada
import { AlquilerService } from './alquiler.service'; // Asegúrate de importar el servicio adecuado
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './alquiler.component.html',
  styleUrls: ['./alquiler.component.css']
})
export class AlquilerComponent implements OnInit {
  public alquileres: Alquiler[] = []; // Cambio de "clientes" a "alquileres"
  public alquileresList: Alquiler[] = []; // Cambio de "clientesList" a "alquileresList"
  public editAlquiler: Alquiler = new Alquiler; // Cambio de "editCliente" a "editAlquiler"
  public deleteAlquiler: Alquiler = new Alquiler; // Cambio de "deleteCliente" a "deleteAlquiler"

  constructor(private alquilerService: AlquilerService) { } // Cambio de "clienteService" a "alquilerService"

  ngOnInit() {
    this.getAlquileres(); // Cambio de "getClientes" a "getAlquileres"
  }

  public getAlquileres(): void {
    this.alquilerService.getAlquileres().subscribe(
      (response: Alquiler[]) => {
        this.alquileres = response; // Cambio de "clientes" a "alquileres"
        this.alquileresList = response; // Cambio de "clientesList" a "alquileresList"
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddAlquiler(addForm: NgForm): void {
    const container = document.getElementById('add-alquiler-form');
  
    if (container) {
      container.click();
      this.alquilerService.addAlquiler(addForm.value).subscribe(
        (response: Alquiler) => {
          console.log(response);
          this.getAlquileres();
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
    } else {
      console.error("El elemento 'add-alquiler-form' no se encontró en el documento.");
    }
  }

  public onUpdateAlquiler(alquiler: Alquiler): void { // Cambio de "onUpdateCliente" a "onUpdateAlquiler"
    this.alquilerService.updateAlquiler(alquiler).subscribe(
      (response: Alquiler) => {
        console.log(response);
        this.getAlquileres();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteAlquiler(alquilerId: number): void { // Cambio de "onDeleteCliente" a "onDeleteAlquiler"
    this.alquilerService.deleteAlquiler(alquilerId).subscribe(
      (response: void) => {
        console.log(response);
        this.getAlquileres();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchAlquileres(key: string): void { // Cambio de "searchClientes" a "searchAlquileres"
    const results: Alquiler[] = [];
    for (const alquiler of this.alquileres) { // Cambio de "cliente" a "alquiler"
      if (alquiler.evento_id.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1
        || alquiler.vestido_id.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1
        || alquiler.fechaentrega.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || alquiler.fechadevolucion.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(alquiler);
      }
    }
    this.alquileresList = results; // Cambio de "clientesList" a "alquileresList"
    if (!key) {
      this.getAlquileres();
    }
  }

  public onOpenModal(alquiler: Alquiler, mode: string): void {
    const container = document.getElementById('main-container');
  
    if (container) {
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
  
      if (mode === 'add') {
        button.setAttribute('data-target', '#addAlquilerModal');
      }
      if (mode === 'edit') {
        this.editAlquiler = alquiler;
        button.setAttribute('data-target', '#updateAlquilerModal');
      }
      if (mode === 'delete') {
        this.deleteAlquiler = alquiler;
        button.setAttribute('data-target', '#deleteAlquilerModal');
      }
  
      container.appendChild(button);
      button.click();
    } else {
      console.error("El elemento 'main-container' no se encontró en el documento.");
    }
  }
  
}
