import { Generic } from './generic';

export class Nurse implements Generic {
  id!: number;
  cedula!: string;
  tarjetaProfesional!: string;
  nombre!: string;
  apellido!: string;
  correo!: string;
  fechaCreacion!: string;
  fotoHashCode!: number;
}
