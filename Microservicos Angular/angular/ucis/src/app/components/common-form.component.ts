import { Component, Directive, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { ActivatedRoute, Router } from '@angular/router';
import { Generic } from '../models/generic';
import { CommonService } from '../services/common.service';

@Directive()
export abstract class CommonFormComponent<
  E extends Generic,
  S extends CommonService<E>
> implements OnInit
{
  title!: string;
  model!: E;
  error: any;
  protected redirect!: string;
  protected nombreModel!: string;

  //Inyeccion de dependencias
  constructor(
    protected service: S,
    protected router: Router,
    protected route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      // const id: number = params.get('id');
      const id: number = +params.get('id');
      if (id) {
        this.service.ver(id).subscribe((m) => (this.model = m));
      }
    });
  }

  public crear(): void {
    this.service.crear(this.model).subscribe(
      (m) => {
        console.log(m);
        Swal.fire(
          'Created:',
          `${this.nombreModel} ${m.id} was created successfully`,
          // `${this.nombreModel} ${m.id} was created successfully`,
          'success'
        );
        this.router.navigate([this.redirect]);
      },
      (err) => {
        if (err.status === 400) {
          this.error = err.error;
          console.log(this.error);
        }
      }
    );
  }
  public editar(): void {
    this.service.editar(this.model).subscribe(
      (m) => {
        console.log(m);
        Swal.fire(
          'Edit',
          `${this.nombreModel} ${m.id} was update successfully`,
          // `${this.nombreModel} ${m.id} was update successfully`,
          'success'
        );
        this.router.navigate([this.redirect]);
      },
      (err) => {
        if (err.status === 400) {
          this.error = err.error;
          console.log(this.error);
        }
      }
    );
  }
}
