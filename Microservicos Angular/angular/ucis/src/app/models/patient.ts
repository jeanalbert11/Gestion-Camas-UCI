import { Generic } from "./generic";

export class Patient implements Generic{
   
    id!: number;
    cedula!: string;
    nombre!: string;
    apellido!: string;
    correo!: string;
    fechaCreacion!: string;
}
