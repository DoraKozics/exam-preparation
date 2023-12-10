import {Component, OnInit} from '@angular/core';
import {LibraryService} from "../../services/library.service";
import {Router} from "@angular/router";
import {BookListItemModel} from "../../models/bookListItem.model";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit{

  bookList: BookListItemModel[] = [];

  constructor(private libraryService: LibraryService, private router: Router) {
  }

  ngOnInit() {
    this.libraryService.getBookList().subscribe({
      next: (data: BookListItemModel[]) => {
        this.bookList = data;
      }
    });
  }

}
