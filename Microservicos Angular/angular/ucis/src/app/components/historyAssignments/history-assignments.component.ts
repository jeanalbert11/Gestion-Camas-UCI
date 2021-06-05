import { Component, OnInit } from '@angular/core';
import { HistoryAssignment } from 'src/app/models/history-assignment';
import { HistoryAssignmentService } from 'src/app/services/history-assignment.service';
import { CommonListarComponent } from '../common-listar.component';

@Component({
  selector: 'app-history-assignments',
  templateUrl: './history-assignments.component.html',
  styleUrls: ['./history-assignments.component.css'],
})
export class HistoryAssignmentsComponent
  extends CommonListarComponent<HistoryAssignment, HistoryAssignmentService>
  implements OnInit
{
  //Inyeccion de dependencias
  constructor(service: HistoryAssignmentService) {
    super(service);
    this.title = 'History Assignments List';
    this.nombreModelo = HistoryAssignment.name;
  }
}
