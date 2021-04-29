import { Conges } from './../../model/conges';
import { Component, OnInit } from '@angular/core';
import { DemandecongeService } from './../../services/demandeconge.service';


@Component({
  selector: 'app-demandeconge-list',
  templateUrl: './demandeconge-list.component.html',
  styleUrls: ['./demandeconge-list.component.css']
})
export class DemandecongeListComponent implements OnInit {

  conges: Conges[];
  constructor(private demandecongeService: DemandecongeService) {}

  ngOnInit(): void {
    this.list();
  }

  delete(id: number) {
    this.demandecongeService.delete(id).subscribe((res) => {
      this.list();
    });
  }


  private list() {
    this.demandecongeService.getConges().subscribe((data) => {
      this.conges = data;
    });
  }
}
