export interface CreateBookCommandModel {
  title: string;
  author: string;
  year: number;
  genres?: string[];
  language: string;
  coverUrl?: string;
}
