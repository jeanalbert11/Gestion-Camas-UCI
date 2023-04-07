import { Generic } from './generic';

export class Nurse implements Generic {
  id!: number;
  identityCard!: string;
  professionalCard!: string;
  name!: string;
  surname!: string;
  email!: string;
  creationDate!: string;
  fotoHashCode!: number;
}
