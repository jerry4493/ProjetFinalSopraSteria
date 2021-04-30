import { Conges } from './../../model/conges';
import { ValidecongeService } from './../../services/valideconge.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DemandecongeService } from 'src/app/services/demandeconge.service';
import { Observable } from 'rxjs';
import { Employe } from 'src/app/model/employe';

@Component({
  selector: 'app-valideconge-edit',
  templateUrl: './valideconge-edit.component.html',
  styleUrls: ['./valideconge-edit.component.css'],
})
export class ValidecongeEditComponent implements OnInit {
  conge: Conges = new Conges();
  employe: Employe = new Employe();

  constructor(
    private validecongeService: ValidecongeService,
    //private demandecongeService: DemandecongeService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
    this.activatedRoute.params.subscribe((params) => {
      if (params.id) {
        this.validecongeService.get(params.id).subscribe((data) => {
          this.conge = data;
        });
      }
    });
  }

  ngOnInit(): void {
    this.employe = JSON.parse(localStorage.getItem('employe'));
  }

  refuse() {
    this.validecongeService.refus(this.conge).subscribe((res) => {
      this.goList();
    });
  }

  validate() {
    this.validecongeService.valide(this.conge).subscribe((res) => {
      this.goList();
    });
  }

  private goList() {
    this.router.navigate(['/validation']);
  }
}
