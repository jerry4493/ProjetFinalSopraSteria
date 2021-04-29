import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemandecongeEditComponent } from './demandeconge/demandeconge-edit/demandeconge-edit.component';
import { DemandecongeListComponent } from './demandeconge/demandeconge-list/demandeconge-list.component';
import { ValidecongeEditComponent } from './valideconge/valideconge-edit/valideconge-edit.component';
import { ValidecongeListComponent } from './valideconge/valideconge-list/valideconge-list.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { routes } from './routes';
import { HomeComponent } from './home/home.component';
import { PageIntrouvableComponent } from './page-introuvable/page-introuvable.component';
import { InscriptionComponent } from './formulaire/inscription/inscription.component';

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
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
