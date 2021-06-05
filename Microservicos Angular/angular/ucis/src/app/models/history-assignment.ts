import { Bed } from './bed';
import { Generic } from './generic';
import { Patient } from './patient';

export class HistoryAssignment implements Generic {
  id!: number;
  patient!: Patient;
  bed!: Bed;
  estado!: boolean;
  fechaInicio!: string;
  fechaFin!: string;
}
