import { Generic } from './generic';
import { Nurse } from './nurse';

export class Bed implements Generic {
  id!: number;
  code!: string;
  state!: boolean;
  // patien!: Patient;
  nurse!: Nurse;
}
