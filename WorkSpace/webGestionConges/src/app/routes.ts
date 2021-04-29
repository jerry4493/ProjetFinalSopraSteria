import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { PageIntrouvableComponent } from './page-introuvable/page-introuvable.component';
import { InscriptionComponent } from './formulaire/inscription/inscription.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },

  { path: 'inscription', component: InscriptionComponent },
  { path: '**', component: PageIntrouvableComponent },
];

export const RoutesRoutes = RouterModule.forChild(routes);
