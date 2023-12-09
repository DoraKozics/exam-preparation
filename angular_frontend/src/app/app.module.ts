import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { BookFormComponent } from './components/book-form/book-form.component';
import { BookListComponent } from './components/book-list/book-list.component';
import { Error404Component } from './components/error404/error404.component';
import { BookSearchComponent } from './components/book-search/book-search.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    BookFormComponent,
    BookListComponent,
    Error404Component,
    BookSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
