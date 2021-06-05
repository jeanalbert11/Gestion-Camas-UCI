import { SelectionModel } from '@angular/cdk/collections';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { clear } from 'console';
import { Bed } from 'src/app/models/bed';
import { Unit } from 'src/app/models/unit';
import { BedService } from 'src/app/services/bed.service';
import { UnitService } from 'src/app/services/unit.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-asignar-camas',
  templateUrl: './asignar-camas.component.html',
  styleUrls: ['./asignar-camas.component.css'],
})
export class AsignarCamasComponent implements OnInit {
  unit!: Unit;
  camasAsignar: Bed[] = [];
  mostrarColumnas: string[] = ['id', 'codigo', 'seleccion'];
  camas: Bed[] = [];
  mostrarColumnasCamas: string[] = ['id', 'codigo', 'eliminar'];
  tabIndex = 0;

  // mostrarColumnas: string[] = ['id', 'codigo', 'nurse', 'seleccion'];

  //true: permite seleccion multiple
  //[] : para guardar los obj beds seleccionados
  seleccion: SelectionModel<Bed> = new SelectionModel<Bed>(true, []);

  //Inyeccion de dependencias
  constructor(
    private route: ActivatedRoute,
    private unitService: UnitService,
    private bedService: BedService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      const id: number = +params.get('id');
      // const id: number = params.get('id');
      this.unitService.ver(id).subscribe((u) => {
        this.unit = u;
        this.camas = this.unit.beds;
      }); //obtenemos id de unit
    });
  }

  filtrarPorCodigo(codigo: string): void {
    codigo = codigo !== undefined ? codigo.trim() : '';
    if (codigo !== '') {
      this.bedService.filtraPorCodigo(codigo).subscribe(
        (camas) =>
          (this.camasAsignar = camas.filter((c) => {
            let filtrar = true;
            // this.unit.beds.forEach((uc) => {
            this.camas.forEach((uc) => {
              if (c.id === uc.id) {
                filtrar = false;
              }
            });
            return filtrar;
          }))
      );
    }
  }
  estanTodosSeleccionados(): boolean {
    const numeroCamasSeleccionadas = this.seleccion.selected.length;
    const numeroFilas = this.camasAsignar.length;
    return numeroCamasSeleccionadas === numeroFilas;
  }
  seleccionarDesSeleccionarTodos(): void {
    this.estanTodosSeleccionados()
      ? this.seleccion.clear()
      : this.camasAsignar.forEach((b) => this.seleccion.select(b));
  }

  // Para el tobon asignar del la vista asignar
  asignar(): void {
    console.log(this.seleccion.selected);
    this.unitService.asignarCamas(this.unit, this.seleccion.selected).subscribe(
      (u) => {
        this.tabIndex = 2;
        Swal.fire(
          'Assigned:',
          `Successfully assigned beds ${this.unit.acronimo}`
        );
        this.camas = this.camas.concat(this.seleccion.selected);
        this.camasAsignar = [];
        this.seleccion.clear();
      },
      (e) => {
        if (e.status === 500) {
          const mensaje = e.error.message as string;
          if (mensaje.indexOf('ConstraintViolationException') > -1) {
            Swal.fire(
              'Careful:',
              `The bed cannot be assigned, it is already assigned to another unit`,
              'error'
            );
          }
        }
      }
    );
  }

  eliminarCama(bed: Bed): void {
    Swal.fire({
      title: `Are you sure you want to eliminate ${bed.codigo}?`,
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#FE0008',
      cancelButtonColor: '#00EBFE',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.unitService.eliminarCama(this.unit, bed).subscribe((unit) => {
          this.camas = this.camas.filter((b)  => b.id !== bed.id);
          Swal.fire(
            'Eliminado:',
            `Cama ${bed.codigo} eliminada con exito de la unidad ${unit.id} `,
            'success'
          );
        });
      }
    });
  }
}
