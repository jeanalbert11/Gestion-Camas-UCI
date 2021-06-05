import { Bed } from './bed';
import { Generic } from './generic';

export class Unit implements Generic {
  id!: number;
  acronimo!: string;
  tipo!: string;
  beds: Bed[] = [];
}
