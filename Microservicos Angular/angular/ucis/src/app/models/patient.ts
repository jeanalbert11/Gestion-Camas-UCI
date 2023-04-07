import { Generic } from "./generic";

export class Patient implements Generic{
   
    id!: number;
    identityCard!: string;
    name!: string;
    surname!: string;
    email!: string;
    creationDate!: string;
}
