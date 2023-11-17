import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente'; // Asegúrate de importar la clase Cliente adecuada
import { ClienteService } from './cliente.service'; // Asegúrate de importar el servicio adecuado
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {
  public clientes: Cliente[] = []; // Cambio de "eventos" a "clientes"
  public clientesList: Cliente[] = []; // Cambio de "eventosList" a "clientesList"
  public editCliente: Cliente = new Cliente; // Cambio de "editEvento" a "editCliente"
  public deleteCliente: Cliente = new Cliente; // Cambio de "deleteEvento" a "deleteCliente"

  constructor(private clienteService: ClienteService) { } // Cambio de "eventoService" a "clienteService"

  ngOnInit() {
    this.getClientes(); // Cambio de "getEventos" a "getClientes"
  }

  public getClientes(): void {
    this.clienteService.getClientes().subscribe(
      (response: Cliente[]) => {
        this.clientes = response; // Cambio de "eventos" a "clientes"
        this.clientesList = response; // Cambio de "eventosList" a "clientesList"
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddCliente(addForm: NgForm): void {
    const container = document.getElementById('add-cliente-form');
  
    if (container) {
      container.click();
      this.clienteService.addCliente(addForm.value).subscribe(
        (response: Cliente) => {
          console.log(response);
          this.getClientes();
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
    } else {
      console.error("El elemento 'add-cliente-form' no se encontró en el documento.");
    }
  }
  

  public onUpdateCliente(cliente: Cliente): void { // Cambio de "onUpdateEvento" a "onUpdateCliente"
    this.clienteService.updateCliente(cliente).subscribe(
      (response: Cliente) => {
        console.log(response);
        this.getClientes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteCliente(clienteId: number): void { // Cambio de "onDeleteEvento" a "onDeleteCliente"
    this.clienteService.deleteCliente(clienteId).subscribe(
      (response: void) => {
        console.log(response);
        this.getClientes();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchClientes(key: string): void { // Cambio de "searchEventos" a "searchClientes"
    const results: Cliente[] = [];
    for (const cliente of this.clientes) { // Cambio de "evento" a "cliente"
      if (cliente.nombre.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || cliente.apellido.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || cliente.dni.toString().toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(cliente);
      }
    }
    this.clientesList = results; // Cambio de "eventosList" a "clientesList"
    if (!key) {
      this.getClientes();
    }
  }

  public onOpenClienteModal(cliente: Cliente, mode: string): void {
    const container = document.getElementById('main-container');
  
    if (container) {
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
  
      if (mode === 'add') {
        button.setAttribute('data-target', '#addClienteModal');
      }
      if (mode === 'edit') {
        this.editCliente = cliente;
        button.setAttribute('data-target', '#updateClienteModal');
      }
      if (mode === 'delete') {
        this.deleteCliente = cliente;
        button.setAttribute('data-target', '#deleteClienteModal');
      }
  
      container.appendChild(button);
      button.click();
    } else {
      console.error("El elemento 'main-container' no se encontró en el documento.");
    }
  }
  
}
