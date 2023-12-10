import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {CreateBookCommandModel} from "../models/createBookCommand.model";
import {Observable} from "rxjs";
import {InitBookFormDataModel} from "../models/initBookFormData.model";
import {BookListItemModel} from "../models/bookListItem.model";

const BASE_URL = "http://localhost:8080/api";

@Injectable({
  providedIn: 'root'
})
export class LibraryService {

  constructor(private http: HttpClient) {
  }

  getInitBookFormData = (): Observable<InitBookFormDataModel> => {
    return this.http.get<InitBookFormDataModel>(BASE_URL + "/initBookForm");
  }

  createBook = (data: CreateBookCommandModel): Observable<any> => {
    return this.http.post(BASE_URL + "/books", data);
  }

  getBookList = (): Observable<BookListItemModel[]> => {
    return this.http.get<BookListItemModel[]>(BASE_URL + "/books");
  }
}
