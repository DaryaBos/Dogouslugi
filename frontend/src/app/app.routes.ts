/**
 * Роутинг для проекта
 * Прописано по какому url какой компонент использовать
 */

import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadChildren: () => import('./modules/main/main.module').then(mod => mod.MainModule)
  },
  {
    path: 'dogs',
    pathMatch: 'full',
    loadChildren: () => import('./modules/dogs-list/dogs-list.module').then(mod => mod.DogsListModule)
  },
  {
    path: 'add-dog',
    pathMatch: 'full',
    loadChildren: () => import('./modules/add-dog/add-dog.module').then(mod => mod.AddDogModule)
  },
  {
    path: 'orders',
    pathMatch: 'full',
    loadChildren: () => import('./modules/orders/orders.module').then(mod => mod.OrdersModule)
  },
  {
    path: 'service',
    loadChildren: () => import('./modules/service/service.module').then(mod => mod.ServiceModule)
  },
  {
    path: '**',
    loadChildren: () => import('./modules/not-found/not-found.module').then(mod => mod.NotFoundModule)
  }
];
