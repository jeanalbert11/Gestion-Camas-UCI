export class User {
  id!: number;
  username!: string;
  password!: string;
  enabled!: string;
  email!: string;
  roles: string[] = [];
}
