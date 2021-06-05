import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Generic } from '../models/generic';

export abstract class CommonService<E extends Generic> {
  protected urlEndPoint!: string;
  protected cabeceras: HttpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
  });

  //Inyeccion de dependencias
  constructor(protected http: HttpClient) {}

  public listar(): Observable<E[]> {
    return this.http.get<E[]>(this.urlEndPoint);
  }

  public ver(id: number): Observable<E> {
    return this.http.get<E>(`${this.urlEndPoint}/${id}`);
  }

  public crear(e: E): Observable<E> {
    return this.http.post<E>(this.urlEndPoint, e, {
      headers: this.cabeceras,
    });
  }

  public editar(e: E): Observable<E> {
    return this.http.put<E>(`${this.urlEndPoint}/${e.id}`, e, {
      headers: this.cabeceras,
    });
  }

  public eliminar(id: number): Observable<void> {
    return this.http.delete<void>(`${this.urlEndPoint}/${id}`);
  }
}
