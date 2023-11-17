import { Component, OnInit } from '@angular/core';
import { Evento } from './evento'; // Asegúrate de importar la clase Evento adecuada
import { EventoService } from './evento.service'; // Asegúrate de importar el servicio adecuado
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './evento.component.html',
  styleUrls: ['./evento.component.css']
})
export class EventoComponent implements OnInit {
  public eventos: Evento[] = []; // Cambio de "precios" a "eventos"
  public eventosList: Evento[] = []; // Cambio de "preciosList" a "eventosList"
  public editEvento: Evento = new Evento; // Cambio de "editPrecio" a "editEvento"
  public deleteEvento: Evento = new Evento; // Cambio de "deletePrecio" a "deleteEvento"

  constructor(private eventoService: EventoService) { } // Cambio de "precioService" a "eventoService"

  ngOnInit() {
    this.getEventos(); // Cambio de "getPrecios" a "getEventos"
  }

  public getEventos(): void {
    this.eventoService.getEventos().subscribe(
      (response: Evento[]) => {
        this.eventos = response; // Cambio de "precios" a "eventos"
        this.eventosList = response; // Cambio de "preciosList" a "eventosList"
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  // Método para agregar un evento
public onAddEvento(addForm: NgForm): void {
  const container = document.getElementById('add-evento-form');

  if (container) {
    container.click();
    this.eventoService.addEvento(addForm.value).subscribe(
      (response: Evento) => {
        console.log(response);
        this.getEventos();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  } else {
    console.error("El elemento 'add-evento-form' no se encontró en el documento.");
  }
}

  public onUpdateEvento(evento: Evento): void { // Cambio de "onUpdatePrecio" a "onUpdateEvento"
    this.eventoService.updateEvento(evento).subscribe(
      (response: Evento) => {
        console.log(response);
        this.getEventos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEvento(eventoId: number): void { // Cambio de "onDeletePrecio" a "onDeleteEvento"
    this.eventoService.deleteEvento(eventoId).subscribe(
      (response: void) => {
        console.log(response);
        this.getEventos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchEventos(key: string): void { // Cambio de "searchPrecios" a "searchEventos"
    const results: Evento[] = [];
    for (const evento of this.eventos) { // Cambio de "precio" a "evento"
      if (evento.evento.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(evento);
      }
    }
    this.eventosList = results; // Cambio de "preciosList" a "eventosList"
    if (!key) {
      this.getEventos();
    }
  }

  public onOpenEventoModal(evento: Evento, mode: string): void {
    const container = document.getElementById('main-container');
  
    if (container) {
      const button = document.createElement('button');
      button.type = 'button';
      button.style.display = 'none';
      button.setAttribute('data-toggle', 'modal');
  
      if (mode === 'add') {
        button.setAttribute('data-target', '#addEventoModal');
      }
      if (mode === 'edit') {
        this.editEvento = evento;
        button.setAttribute('data-target', '#updateEventoModal');
      }
      if (mode === 'delete') {
        this.deleteEvento = evento;
        button.setAttribute('data-target', '#deleteEventoModal');
      }
  
      container.appendChild(button);
      button.click();
    } else {
      console.error("El elemento 'main-container' no se encontró en el documento.");
    }
  }
}
