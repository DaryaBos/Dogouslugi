import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDogComponent } from './add-dog.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: AddDogComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes),
  ]
})
export class AddDogModule { }
