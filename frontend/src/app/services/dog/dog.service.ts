import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { EBreedMap, ESexMap, IDog, TBreed, TSex } from '@models/dog.model';

@Injectable({
  providedIn: 'root'
})
export class DogService {

  private dogApi = 'api/dog/';

  constructor(
    public http: HttpClient,
  ) { }

  /**
   * Возвращает список собачек
   */
  public getDogList(): Observable<IDog[]> {
    return this.http.get<IDog[]>(`${this.dogApi}list`);
  }

  /**
   * Возвращает значение пола в человеческом виде
   * @param sexId
   */
  public getSexMap(sexId: TSex): ESexMap {
    return ESexMap[sexId];
  }

  /**
   * Возвращает значение пола в человеческом виде
   * @param breedId
   */
  public getBreedMap(breedId: TBreed): EBreedMap {
    return EBreedMap[breedId];
  }

  /**
   * Сохраняет собачку в БД
   * @param dogInfo - данные с формы
   */
  public addDog(dogInfo: any) {
    return this.http.post<IDog>(`${this.dogApi}add`, this.prepareInfo(dogInfo));
  }

  /**
   * Преобразует данные с формы для отправки на бэк
   * @param dogInfo - данные с формы
   */
  private prepareInfo(dogInfo: any) {
    let res: {[key: string]: string | number} = {};

    Object.keys(dogInfo).forEach(key => {
      let value = dogInfo[key];
      try {
        value = JSON.parse(value)?.id ?? value;
      } catch (error) {}
      Object.assign(res, {[key]: value});
    });

    return res;
  }

  /**
   * Удаляет собачку из БД
   * @param id
   */
  public deleteDog(id: number) {
    return this.http.delete<IDog>(`${this.dogApi}deleteDog`, {
      params: {
        id
      }
    });
  }

}
