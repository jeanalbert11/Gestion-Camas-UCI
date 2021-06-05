import { Generic } from './generic';

export class Hospital implements Generic {
  id!: number;
  nombre!: string;
  razonSocial!: string;
  telefono!: string;
  direccion!: string;
  tipo!: string;
}
