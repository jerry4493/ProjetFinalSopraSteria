import { Routes, RouterModule } from '@angular/router';
import { DemandecongeEditComponent } from './demandeconge/demandeconge-edit/demandeconge-edit.component';
import { DemandecongeListComponent } from './demandeconge/demandeconge-list/demandeconge-list.component';

export const routes: Routes = [


  {path: 'conge/edit',
  component: DemandecongeEditComponent},

  {
    path: 'conge',
    component: DemandecongeListComponent
  },
];




export const RoutesRoutes = RouterModule.forChild(routes);
