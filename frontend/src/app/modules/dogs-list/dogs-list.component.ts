import { Component, OnInit } from '@angular/core';
import { DogService } from '@services/dog/dog.service';
import { take } from 'rxjs';
import { EBreedMap, IDog, TBreed, ESexMap, TSex } from '@models/dog.model';
import { Router } from '@angular/router';
import { ThrobberComponent } from '@components/throbber/throbber.component';

@Component({
  selector: 'app-dogs-list',
  standalone: true,
  imports: [
    ThrobberComponent
  ],
  templateUrl: './dogs-list.component.html',
  styleUrl: './dogs-list.component.scss'
})
export class DogsListComponent implements OnInit {

  public loading = true; // загружена ли информация для страницы
  public dogsList: IDog[]; // список собачек
  public ESexMap = ESexMap; // маппинг пола

  constructor(
    private dogService: DogService,
    private router: Router,
  ) {
  }

  public ngOnInit(): void {
    // получаем список собачек
    this.dogService.getDogList().pipe(
      take(1)
    ).subscribe(res => {
      this.dogsList = res;
      this.loading = false;
    });
  }

  /**
   * Возвращает породу человеческим значением
   * @param breedId - идентификатор породы
   */
  public getBreed(breedId: TBreed): EBreedMap {
    return this.dogService.getBreedMap(breedId);
  }

  /**
   * Возвращает пол человеческим значением
   * @param sexId
   */
  public getSex(sexId: TSex): ESexMap {
    return this.dogService.getSexMap(sexId);
  }

  /**
   * Редирект на страницу добавления собачки
   */
  public addDog(): void {
    this.router.navigate(['add-dog']);
  }

  /**
   * Удалить собачки
   * @param id - индентификатор собачки
   */
  public deleteDog(id: number): void {
    this.dogService.deleteDog(id).subscribe(res => {
      alert('Собачка удален\nНажмите «OK» для продолжения работы с порталом');
      const indexDog = this.dogsList.findIndex(dog => dog.id === id);
      this.dogsList.splice(indexDog, 1);
    }, error => {
      alert('Произошла ошибка, повторите попытку позже\nНажмите «OK» для продолжения работы с порталом');
    });
  }

}
