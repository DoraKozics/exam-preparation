import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookListComponent} from "./components/book-list/book-list.component";
import {BookFormComponent} from "./components/book-form/book-form.component";
import {Error404Component} from "./components/error404/error404.component";
import {BookSearchComponent} from "./components/book-search/book-search.component";
import {BorrowFormComponent} from "./components/borrow-form/borrow-form.component";
import {BorrowListComponent} from "./components/borrow-list/borrow-list.component";
import {SummaryComponent} from "./components/summary/summary.component";

const routes: Routes = [
  {path: '', component: BookListComponent},
  {path: 'books/list', component: BookListComponent},
  {path: 'books/form', component: BookFormComponent},
  {path: 'books/search', component: BookSearchComponent},
  {path: 'borrowings/form', component: BorrowFormComponent},
  {path: 'borrowings/list', component: BorrowListComponent},
  {path: 'summary', component: SummaryComponent},
  {path: '**', component: Error404Component}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
