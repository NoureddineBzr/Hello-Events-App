import { Component } from '@angular/core';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  form: any = {
    username: null,
    email: null,
    password: null,
    age: null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  onSubmit(): void {
    const { username, email, password, age } = this.form;

    console.log('Form Data:', this.form);

    this.authService.register(username, email, password, age).subscribe({
      next: data => {
        console.log('Success Response:', data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      error: err => {
        console.error('Error Response:', err);
        this.errorMessage = err.error.message || 'An error occurred during registration.';
        this.isSignUpFailed = true;
      }
    });
  }
}
