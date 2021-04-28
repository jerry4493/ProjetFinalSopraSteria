import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DemandecongeEditComponent } from './demandeconge/demandeconge-edit/demandeconge-edit.component';
import { DemandecongeListComponent } from './demandeconge/demandeconge-list/demandeconge-list.component';
import { ValidecongeEditComponent } from './valideconge/valideconge-edit/valideconge-edit.component';
import { ValidecongeListComponent } from './valideconge/valideconge-list/valideconge-list.component';

@NgModule({
  declarations: [
    AppComponent,
    DemandecongeEditComponent,
    DemandecongeListComponent,
    ValidecongeEditComponent,
    ValidecongeListComponent,
  ],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
