import { Injectable } from '@angular/core';
import { EBreedMap, ESexMap, IValueBreed, IValueSex, IValueDog, IDogGroupedBySex } from '@models/dog.model';
import { mergeMap, Observable, of, take } from 'rxjs';
import { DogService } from '@services/dog/dog.service';
import { IValue } from '@models/common.model';
import { IValueName } from '@models/common.model';

@Injectable({
  providedIn: 'root'
})
export class ConstantsService {

  // варианты пола
  public sexOptions: IValueSex[] = [
    {
      id: 'male',
      text: ESexMap.male
    },
    {
      id: 'female',
      text: ESexMap.female
    }
  ];

  // варианты пород
  public breedOptions: IValueBreed[] = [
    {
      id: 'spitz',
      text: EBreedMap.spitz
    },
    {
      id: 'chihuahua',
      text: EBreedMap.chihuahua
    },
    {
      id: 'corgi',
      text: EBreedMap.corgi
    },
    {
      id: 'shepherd',
      text: EBreedMap.shepherd
    },
    {
      id: 'york',
      text: EBreedMap.york
    },
    {
      id: 'labrador_retriever',
      text: EBreedMap.labrador_retriever
    },
    {
      id: 'jack_russell_terrier',
      text: EBreedMap.jack_russell_terrier
    },
    {
      id: 'bulldog',
      text: EBreedMap.bulldog
    },
  {
    id: 'poodle',
    text: EBreedMap.poodle
  },
  {
    id: 'pug',
    text: EBreedMap.pug
  },
  {
    id: 'bully',
    text: EBreedMap.bully
  },
  {
    id: 'beagle',
    text: EBreedMap.beagle
  }
  ];

  // варианты специалистов
  public doctorOptions: IValue[] = [
    {
      id: 0,
      text: 'Терапевт'
    },
    {
      id: 1,
      text: 'Невролог'
    },
    {
      id: 2,
      text: 'Диетолог'
    },
    {
      id: 3,
      text: 'Хирург'
    },
    {
      id: 4,
      text: 'Дерматолог'
    }
  ];

  // варианты мастеров
  public groomerOptions: IValueName[] = [
    {
      id: 0,
      text: 'Марина'
    },
    {
      id: 1,
      text: 'Федор'
    },
    {
      id: 2,
      text: 'Михаил'
    },
    {
      id: 3,
      text: 'Анастасия'
    },
    {
      id: 4,
      text: 'Вероника'
    }
  ];

  constructor(
    private dogService: DogService,
  ) { }

  /**
   * Возвращает список собачек сгруппированных по полу, преобразовывая ответ для использования в dropdown
   */
  public getDogOptionsBySex(): Observable<IDogGroupedBySex> {
    return this.dogService.getDogList().pipe(
      take(1)
    ).pipe(
      mergeMap((res) => {
        const male: IValueDog[] = [];
        const female: IValueDog[] = [];
        res.forEach(item => {
          if (item.sex === 'male') {
            male.push({id: item.id, text: item.name});
          } else {
            female.push({id: item.id, text: item.name});
          }
        });
        return of({
          male,
          female
        });
      })
    );
  }

  /**
   * Возвращает список собачек, преобразовывая ответ для использования в dropdown
   */
  public getDogOptionsAll():  Observable<IValueDog[]> {
    return this.dogService.getDogList().pipe(
      take(1)
    ).pipe(
      mergeMap((res) => {
        return of(res.map((item) => {
          return {
            id: item.id,
            text: item.name
          }
        }));
      })
    )
  }
}
