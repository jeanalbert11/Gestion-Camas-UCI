import { Generic } from './generic';
import { Nurse } from './nurse';
import { Patient } from './patient';

export class Bed implements Generic {
  id!: number;
  codigo!: string;
  //estado!: boolean;
  // patien!: Patient;
  nurse!: Nurse;
}
