import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { DemandecongeEditComponent } from './demandeconge/demandeconge-edit/demandeconge-edit.component';
import { DemandecongeListComponent } from './demandeconge/demandeconge-list/demandeconge-list.component';
import { routes } from './routes';
import { ValidecongeEditComponent } from './valideconge/valideconge-edit/valideconge-edit.component';
import { ValidecongeListComponent } from './valideconge/valideconge-list/valideconge-list.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PageIntrouvableComponent } from './page-introuvable/page-introuvable.component';
import { InscriptionComponent } from './formulaire/inscription/inscription.component';

import { NoopAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    DemandecongeEditComponent,
    DemandecongeListComponent,
    ValidecongeEditComponent,
    ValidecongeListComponent,
    LoginComponent,
    HomeComponent,
    PageIntrouvableComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    NoopAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
