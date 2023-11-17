import { Component, OnInit } from '@angular/core';
import { Precio } from './precio'; // Asegúrate de importar la clase Precio adecuada
import { PrecioService } from './precio.service'; // Asegúrate de importar el servicio adecuado
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './precio.component.html',
  styleUrls: ['./precio.component.css']
})
export class PrecioComponent implements OnInit {
  public precios: Precio[] = []; // Cambio de "vestidos" a "precios"
  public preciosList: Precio[] = []; // Cambio de "vestidosList" a "preciosList"
  public editPrecio: Precio = new Precio; // Cambio de "editVestido" a "editPrecio"
  public deletePrecio: Precio = new Precio; // Cambio de "deleteVestido" a "deletePrecio"

  constructor(private precioService: PrecioService) { } // Cambio de "vestidoService" a "precioService"

  ngOnInit() {
    this.getPrecios(); // Cambio de "getVestidos" a "getPrecios"
  }

  public getPrecios(): void {
    this.precioService.getPrecios().subscribe(
      (response: Precio[]) => {
        this.precios = response; // Cambio de "vestidos" a "precios"
        this.preciosList = response; // Cambio de "vestidosList" a "preciosList"
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

 // Agregar un precio
public onAddPrecio(addForm: NgForm): void {
  const container = document.getElementById('add-precio-form');

  if (container) {
    container.click();
    this.precioService.addPrecio(addForm.value).subscribe(
      (response: Precio) => {
        console.log(response);
        this.getPrecios();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  } else {
    console.error("El elemento 'add-precio-form' no se encontró en el documento.");
  }
}


  public onUpdatePrecio(precio: Precio): void { // Cambio de "onUpdateVestido" a "onUpdatePrecio"
    this.precioService.updatePrecio(precio).subscribe(
      (response: Precio) => {
        console.log(response);
        this.getPrecios();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeletePrecio(precioId: number): void { // Cambio de "onDeleteVestido" a "onDeletePrecio"
    this.precioService.deletePrecio(precioId).subscribe(
      (response: void) => {
        console.log(response);
        this.getPrecios();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchPrecios(key: string): void { // Cambio de "searchVestidos" a "searchPrecios"
    const results: Precio[] = [];
    for (const precio of this.precios) { // Cambio de "vestido" a "precio"
      if (precio.preciocolor.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(precio);
      }
    }
    this.preciosList = results; // Cambio de "vestidosList" a "preciosList"
    if (!key) {
      this.getPrecios();
    }
  }

 // Abrir modal relacionado con precio
public onOpenPrecioModal(precio: Precio, mode: string): void {
  const container = document.getElementById('main-container');

  if (container) {
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');

    if (mode === 'add') {
      button.setAttribute('data-target', '#addPrecioModal');
    }
    if (mode === 'edit') {
      this.editPrecio = precio;
      button.setAttribute('data-target', '#updatePrecioModal');
    }
    if (mode === 'delete') {
      this.deletePrecio = precio;
      button.setAttribute('data-target', '#deletePrecioModal');
    }

    container.appendChild(button);
    button.click();
  } else {
    console.error("El elemento 'main-container' no se encontró en el documento.");
  }
}

}
