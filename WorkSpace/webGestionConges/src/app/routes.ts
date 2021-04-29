import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PageIntrouvableComponent } from './page-introuvable/page-introuvable.component';
import { InscriptionComponent } from './formulaire/inscription/inscription.component';
import { DemandecongeEditComponent } from './demandeconge/demandeconge-edit/demandeconge-edit.component';
import { DemandecongeListComponent } from './demandeconge/demandeconge-list/demandeconge-list.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
export const routes: Routes = [

  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  { path: 'inscription', component: InscriptionComponent },
  { path: '**', component: PageIntrouvableComponent },
];


  {path: 'conge/edit',
  component: DemandecongeEditComponent},

  {
    path: 'conge',
    component: DemandecongeListComponent
  },
];




export const RoutesRoutes = RouterModule.forChild(routes);
