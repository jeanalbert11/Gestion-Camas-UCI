import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // title: string = 'Login';
  // user!: User;

  // //Inyeccion de dependencias
  // constructor(private authService: AuthService, private router: Router) {
  //   this.user = new User();
  // }

  ngOnInit(): void {
  }

  // public login(): void {
  //   if(this.user.username == null || this.user.password == null){
  //     alert("Usuario o password estan vacios");
  //   }
  //   this.authService.login(this.user).subscribe((reponse) => {
  //     this.router.navigate(['/home']);
  //     alert('has iniciado sesion correctamente');
  //   });
  // }

}
