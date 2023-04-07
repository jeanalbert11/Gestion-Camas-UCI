import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bed } from 'src/app/models/bed';
import { HistoryAssignment } from 'src/app/models/history-assignment';
import { Patient } from 'src/app/models/patient';
import { HistoryAssignmentService } from 'src/app/services/history-assignment.service';
import { CommonFormComponent } from '../common-form.component';

@Component({
  selector: 'app-history-assignments-form',
  templateUrl: './history-assignments-form.component.html',
  styleUrls: ['./history-assignments-form.component.css'],
})
export class HistoryAssignmentsFormComponent
  extends CommonFormComponent<HistoryAssignment, HistoryAssignmentService>
  implements OnInit
{
  hospital: HistoryAssignment = new HistoryAssignment();
  error: any;
  //Para llenar el drown down list
  patients: Patient[] = [];
  beds: Bed[] = [];

  //Inyeccion de dependencias
  constructor(
    service: HistoryAssignmentService,
    router: Router,
    route: ActivatedRoute
  ) {
    super(service, router, route);
    this.title = 'Create history assignment';
    this.model = new HistoryAssignment();
    this.redirect = '/historyAssignments';
    this.nombreModel = HistoryAssignment.name;
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      // const id: number = params.get('id');
      const id: number = +params.get('id');
      if (id) {
        this.service.ver(id).subscribe((m) => {
          this.model = m;
          this.title = 'Editar ' + this.nombreModel;
        });
      }
    });
    // obtenemos todas las pacientes
    this.service
      .findAllPatients()
      .subscribe((patients) => (this.patients = patients));
    // obtenemos todas las pacientes
    this.service.findAllBeds().subscribe((beds) => (this.beds = beds));
  }
}
