import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BookListComponent} from "./components/book-list/book-list.component";
import {BookFormComponent} from "./components/book-form/book-form.component";
import {Error404Component} from "./components/error404/error404.component";
import {BookSearchComponent} from "./components/book-search/book-search.component";

const routes: Routes = [
  {path: '', component: BookListComponent},
  {path: 'list', component: BookListComponent},
  {path: 'form', component: BookFormComponent},
  {path: 'search', component: BookSearchComponent},
  {path: '**', component: Error404Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
