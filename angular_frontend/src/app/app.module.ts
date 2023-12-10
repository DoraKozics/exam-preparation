import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavbarComponent} from './components/navbar/navbar.component';
import {BookFormComponent} from './components/book-form/book-form.component';
import {BookListComponent} from './components/book-list/book-list.component';
import {Error404Component} from './components/error404/error404.component';
import {BookSearchComponent} from './components/book-search/book-search.component';
import {BorrowFormComponent} from './components/borrow-form/borrow-form.component';
import {BorrowListComponent} from './components/borrow-list/borrow-list.component';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { SummaryComponent } from './components/summary/summary.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BookFormComponent,
    BookListComponent,
    Error404Component,
    BookSearchComponent,
    BorrowFormComponent,
    BorrowListComponent,
    SummaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
