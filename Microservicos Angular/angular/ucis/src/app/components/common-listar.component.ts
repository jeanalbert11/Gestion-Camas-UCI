import { Directive, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Generic } from '../models/generic';
import { CommonService } from '../services/common.service';

@Directive()
export abstract class CommonListarComponent<
  E extends Generic,
  S extends CommonService<E>
> implements OnInit
{
  title!: string;
  lista!: E[];
  protected nombreModelo!: string;

  //Inyeccion de dependencias
  constructor(protected service: S) {}

  ngOnInit(): void {
    this.service.listar().subscribe((lista) => (this.lista = lista));
  }

  public eliminar(e: E): void {
    Swal.fire({
      title: `Are you sure you want to eliminate ${e.id}?`,
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#FE0008',
      cancelButtonColor: '#00EBFE',
      confirmButtonText: 'Yes, delete it!',
    }).then((result) => {
      if (result.isConfirmed) {
        this.service.eliminar(e.id).subscribe(() => {
          this.lista = this.lista.filter((p) => p !== e);
          Swal.fire(
            'Delete',
            `${this.nombreModelo} ${e.id} was delete successfully`,
            'warning'
          );
        });
      }
    });
  }
}
