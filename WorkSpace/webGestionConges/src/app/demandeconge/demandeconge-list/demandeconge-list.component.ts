import { Employe } from 'src/app/model/employe';
import { Conges } from './../../model/conges';
import { Component, OnInit } from '@angular/core';
import { DemandecongeService } from './../../services/demandeconge.service';

@Component({
  selector: 'app-demandeconge-list',
  templateUrl: './demandeconge-list.component.html',
  styleUrls: ['./demandeconge-list.component.css'],
})
export class DemandecongeListComponent implements OnInit {
  employe: Employe = new Employe();
  conges: Conges[];
  constructor(private demandecongeService: DemandecongeService) {}

  ngOnInit(): void {
    this.employe = JSON.parse(localStorage.getItem('employe'));
    this.list();
  }

  delete(id: number) {
    this.demandecongeService.delete(id).subscribe((res) => {
      this.list();
    });
  }

  private list() {
    this.demandecongeService.getConges(this.employe.id).subscribe((data) => {
      console.log(data);
      this.conges = data;
    });
  }
}
