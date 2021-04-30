import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PageIntrouvableComponent } from './page-introuvable/page-introuvable.component';
import { InscriptionComponent } from './formulaire/inscription/inscription.component';
import { DemandecongeEditComponent } from './demandeconge/demandeconge-edit/demandeconge-edit.component';
import { DemandecongeListComponent } from './demandeconge/demandeconge-list/demandeconge-list.component';
import { ValidecongeEditComponent } from './valideconge/valideconge-edit/valideconge-edit.component';
import { ValidecongeListComponent } from './valideconge/valideconge-list/valideconge-list.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  {
    path: 'validation',
    component: ValidecongeListComponent,
  },
  {
    path: 'validation/edit/:id',
    component: ValidecongeEditComponent,
  },
  {
    path: 'conge/edit',
    component: DemandecongeEditComponent,
  },

  {
    path: 'conge',
    component: DemandecongeListComponent,
  },

  { path: 'inscription', component: InscriptionComponent },

  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  { path: '**', component: PageIntrouvableComponent },
];

export const RoutesRoutes = RouterModule.forChild(routes);
