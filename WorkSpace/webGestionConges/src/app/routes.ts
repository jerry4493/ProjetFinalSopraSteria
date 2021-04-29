import { Routes, RouterModule } from '@angular/router';
import { ValidecongeEditComponent } from './valideconge/valideconge-edit/valideconge-edit.component';
import { ValidecongeListComponent } from './valideconge/valideconge-list/valideconge-list.component';

export const routes: Routes = [
  {
    path: 'validation',
    component: ValidecongeListComponent,
  },
  {
    path: 'validation/edit',
    component: ValidecongeEditComponent,
  },
];

//export const RoutesRoutes = RouterModule.forChild(routes);
