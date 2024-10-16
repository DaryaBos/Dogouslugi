import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DogsListComponent} from './dogs-list.component';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    component: DogsListComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(routes),
  ]
})

export class DogsListModule { }
