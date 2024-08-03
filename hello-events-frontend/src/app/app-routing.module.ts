import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { UserManagementComponent } from './board-admin/user-management/user-management.component';
import { EventListComponent } from './board-admin/event-list/event-list.component';
import { EventAddComponent } from './board-admin/event-add/event-add.component';
import { EventEditComponent } from './board-admin/event-edit/event-edit.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  {
    path: 'admin', component: BoardAdminComponent, children: [
      { path: 'home', component: HomeComponent },
      { path: 'user-management', component: UserManagementComponent },
      { path: 'events', component: EventListComponent },
      { path: 'events/add', component: EventAddComponent },
      { path: 'events/edit/:id', component: EventEditComponent },
      { path: '', redirectTo: 'home', pathMatch: 'full' }
    ]
  },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
