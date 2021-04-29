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
  demandeconge: Observable<Conges[]>;

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
    //this.demandeconge = this.demandecongeService.getConges(); => Récupérer demande congé de Morgan
  }

  ngOnInit(): void {}

  delete(id: number) {
    this.validecongeService.delete(id).subscribe((res) => {
      this.demandeconge = this.validecongeService.list();
    });
  }

  validate() {
    if (!!this.conge.id) {
      this.validecongeService.update(this.conge).subscribe((res) => {
        this.goList();
      });
    } else {
      this.validecongeService.insert(this.conge).subscribe((res) => {
        this.goList();
      });
    }
  }

  private goList() {
    this.router.navigate(['/valideconge']);
  }
}
