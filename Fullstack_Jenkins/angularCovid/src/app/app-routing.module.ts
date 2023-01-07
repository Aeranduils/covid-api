import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorInfosComponent } from './error-infos/error-infos.component';
import { LoginComponent } from './login/login.component';
import { SearchComponent } from './search/search.component';
import { VaccinationCenterListComponent } from './vaccination-center-list/vaccination-center-list.component';
import { VaccinationCenterComponent } from './vaccination-center/vaccination-center.component';

const routes: Routes = [
  { path: "centers", component: VaccinationCenterListComponent},
  { path: "centers/detail/:id", component: VaccinationCenterComponent},
  { path: "search", component: SearchComponent},
  { path: "infos/429", component: ErrorInfosComponent},
  { path: "login", component: LoginComponent},
  { path: '', redirectTo: '/centers', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
