import { Component, OnInit } from '@angular/core';
import { Vestido } from './vestido';
import { VestidoService } from './vestido.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';


declare global {
  interface JQuery {
    modal(options?: any): any;
  }
}

@Component({
  selector: 'app-vestido',
  templateUrl: './vestido.component.html',
  styleUrls: ['./vestido.component.css']
})
export class VestidoComponent implements OnInit {
  public vestidos: Vestido[] = [];
  public vestidosList: Vestido[] = [];
  public editVestido: Vestido = new Vestido();
  public deleteVestido: Vestido = new Vestido();

  //constructor(private router: Router) { }
  constructor(private vestidoService: VestidoService) {}

  ngOnInit() {
    this.getVestidos();
  }

  public getVestidos(): void {
    this.vestidoService.getVestidos().subscribe(
      (response: Vestido[]) => {
        this.vestidos = response;
        this.vestidosList = response;//sacar el List??
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddVestido(addForm: NgForm): void {
    this.vestidoService.addVestido(addForm.value).subscribe(
      (response: Vestido) => {
        console.log(response);
        this.getVestidos();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateVestido(vestido: Vestido): void {
    this.vestidoService.updateVestido(vestido).subscribe(
      (response: Vestido) => {
        console.log(response);
        this.getVestidos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteVestido(vestidoId: number): void {
    this.vestidoService.deleteVestido(vestidoId).subscribe(
      () => {
        console.log('Vestido eliminado con éxito.');
        this.getVestidos();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public searchVestidos(key: string): void {
    if (key) {
      this.vestidoService.searchVestidos(key).subscribe(
        (results: Vestido[]) => {
          this.vestidosList = results;
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    } else {
      this.getVestidos();
    }
  }

  public onOpenVestidoModal(mode: string, vestido?: any): void {
    if (mode === 'add') {
      // Limpiar los campos del formulario de agregar
      this.clearAddFormFields();
    }

    if (mode === 'edit' && vestido) {
      this.editVestido = vestido;
    }

    if (mode === 'delete' && vestido) {
      this.deleteVestido = vestido;
    }

    const modalId = `#${mode}VestidoModal`;

    $(modalId).modal('show');
  }

  private clearAddFormFields(): void {
    // Limpia los campos del formulario de agregar
    // Puedes agregar la lógica para limpiar los campos de tu formulario aquí
  }
}
