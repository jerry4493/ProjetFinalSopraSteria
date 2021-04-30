import { TypeConge } from './../../type-conge.enum';
import { Employe } from './../../model/employe';
import { DemandecongeService } from './../../services/demandeconge.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Conges } from './../../model/conges';
import { Component, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Login } from 'src/app/model/login';

@Component({
  selector: 'app-demandeconge-edit',
  templateUrl: './demandeconge-edit.component.html',
  styleUrls: ['./demandeconge-edit.component.css'],
})
export class DemandecongeEditComponent implements OnInit {
  conge: Conges = new Conges();
  employe: Employe = new Employe();
  login: Login = new Login();
  id: number = -1;
  pipe = new DatePipe('en-FR');
  now = Date.now();

  keys = Object.keys;
  TypeConge = TypeConge;

  dateajd = this.pipe.transform(this.now, 'dd/MM/yyyy');

  constructor(
    private activatedRoute: ActivatedRoute,
    private demandecongeService: DemandecongeService,
    private router: Router
  ) {
    let debut = Date.now();
  }

  ngOnInit(): void {
    this.employe = JSON.parse(localStorage.getItem('employe'));
  }

  save() {
    this.conge.employe = this.employe;
    console.log(this.conge.employe, this.conge.motif, this.conge.id);
    this.demandecongeService.insert(this.conge).subscribe((data) => {
      this.conge = data;
      this.router.navigate(['/conge']);
    });
  }
}
