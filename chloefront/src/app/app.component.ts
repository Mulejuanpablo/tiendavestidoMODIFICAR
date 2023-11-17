import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery';
import { Router } from '@angular/router';
import { Vestido } from './vestido/vestido';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { VestidoService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'chloefront';
}


