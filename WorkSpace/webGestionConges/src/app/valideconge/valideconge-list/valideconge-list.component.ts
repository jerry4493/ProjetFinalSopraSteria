import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Conges } from 'src/app/model/conges';
import { Employe } from 'src/app/model/employe';
import { ValidecongeService } from 'src/app/services/valideconge.service';

@Component({
  selector: 'app-valideconge-list',
  templateUrl: './valideconge-list.component.html',
  styleUrls: ['./valideconge-list.component.css'],
})
export class ValidecongeListComponent implements OnInit {
  demandeconge: Conges[] = [];
  employe: Employe = new Employe();
  constructor(private validecongeService: ValidecongeService) {}

  ngOnInit(): void {
    this.employe = JSON.parse(localStorage.getItem('employe'));
    this.list();
  }

  private list() {
    this.validecongeService
      .getCongesByManager(this.employe.id)
      .subscribe((data) => {
        this.demandeconge = data;
        console.log(data);
      });
  }
}
