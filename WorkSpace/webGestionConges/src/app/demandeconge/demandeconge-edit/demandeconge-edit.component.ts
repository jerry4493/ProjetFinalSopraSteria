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

  dateajd = this.pipe.transform(this.now, 'dd/MM/yyyy');

  constructor(
    private activatedRoute: ActivatedRoute,
    private demandecongeService: DemandecongeService,
    private router: Router
  ) {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.id = params.id;
        this.demandecongeService.getDemandeConge(this.id).subscribe((data) => {
          console.log(data);
          this.conge = data;
        });
      }
    });

    let debut = Date.now();
  }

  ngOnInit(): void {}

  save() {
    if (this.id == -1) {
      this.demandecongeService.insert(this.conge).subscribe((data) => {
        this.router.navigate(['/conge']);
      });
    } else {
      this.demandecongeService.update(this.conge).subscribe((data) => {
        this.router.navigate(['/conge']);
      });
    }
  }
}
