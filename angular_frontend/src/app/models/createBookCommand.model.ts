export interface CreateBookCommandModel {
  title: string;
  author: string;
  year: number;
  genres: Array<string>;
  language: string;
  coverUrl: string;
}
