import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {LibraryService} from "../../services/library.service";
import {Router} from "@angular/router";
import {validationHandler} from "../../utils/validationHandler";
import {GenreOptionModel} from "../../models/genreOption.model";
import {LanguageOptionModel} from "../../models/languageOption.model";
import {InitBookFormDataModel} from "../../models/initBookFormData.model";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.css']
})
export class BookFormComponent implements OnInit {

  bookForm!: FormGroup;
  genreOptions: GenreOptionModel[] = [];
  languageOptions: LanguageOptionModel[] = [];

  constructor(private formBuilder: FormBuilder,
              private libraryService: LibraryService,
              private router: Router) {
    this.bookForm = this.formBuilder.group({
      title: ['', [Validators.required, Validators.minLength(1), Validators.maxLength(300)]],
      author: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(80)]],
      year: ['', [Validators.required, Validators.min(1000), Validators.max(2024)]],
      genres: this.formBuilder.array(['']),
      language: ['', Validators.required],
      coverUrl: ['']
    })
  }

  ngOnInit() {
    this.libraryService.getInitBookFormData().subscribe({
      next: (data: InitBookFormDataModel) => {
        this.genreOptions = data.genreOptions;
        this.languageOptions = data.languageOptions;
        this.createGenreCheckboxControls();
      }
    });
  }

  createGenreCheckboxControls = () => {
    this.genreOptions.forEach(() => {
      const control = new FormControl(false);
      (this.bookForm.controls['genres'] as FormArray).push(control);
    });
  }

  getGenreCheckedOptions = (): string[] => {
    const checkedOptions = this.bookForm.value.genres;
    let result: string[] = [];

    for (let i = 0; i < checkedOptions.length; i++) {
      if (checkedOptions[i]) {
        result.push(this.genreOptions[i].name);
      }
    }
    return result;
  }

  onSubmit = () => {
    const data = this.bookForm.value;
    data.genres = this.getGenreCheckedOptions();
    console.log(data);
    this.libraryService.createBook(data).subscribe({
      next: () => {
        this.router.navigate(['/books/list'])
      },
      error: (err) => validationHandler(err, this.bookForm)
    })
  }
}
