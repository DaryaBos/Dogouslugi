export interface IDog {
  id: number;
  name: string;
  age: string;
  sex: TSex;
  breed: TBreed;
}

export interface IValueSex {
  id: TSex;
  text: ESexMap;
}

export type TSex = 'male' | 'female';

export enum ESexMap {
  male = 'Кобель',
  female = 'Сучка'
}

export interface IValueBreed {
  id: TBreed;
  text: EBreedMap;
}

export type TBreed = 'spitz' | 'chihuahua' | 'corgi' | 'shepherd' | 'york' | 'labrador_retriever'
  | 'jack_russell_terrier' | 'bulldog'| 'poodle' | 'pug' | 'bully' | 'beagle';

export enum EBreedMap {
  spitz = 'Шпиц',
  chihuahua = 'Чихуа-хуа',
  corgi = 'Корги',
  shepherd = 'Немецкая овчарка',
  york = 'Йоркширский терьер',
  labrador_retriever = 'Лабрадор-ретривер',
  jack_russell_terrier = 'Джек-рассел-терьера',
  bulldog = 'Французский бульдог',
  poodle = 'Пудель',
  pug = 'Мопс',
  bully = 'Булли',
  beagle = 'Бигль',
}

export interface IDogGroupedBySex {
  male: IValueDog[];
  female: IValueDog[];
}

export interface IValueDog {
  id: number;
  text: string;
}
