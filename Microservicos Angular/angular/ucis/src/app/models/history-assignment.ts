import { Bed } from './bed';
import { Generic } from './generic';
import { Patient } from './patient';

export class HistoryAssignment implements Generic {
  id!: number;
  patient!: Patient;
  bed!: Bed;
  startDate!: string;
  endDate!: string;
}
