import {GenreOptionModel} from "./genreOption.model";
import {LanguageOptionModel} from "./languageOption.model";

export interface InitBookFormDataModel {
  genreOptions: GenreOptionModel[];
  languageOptions: LanguageOptionModel[];
}
