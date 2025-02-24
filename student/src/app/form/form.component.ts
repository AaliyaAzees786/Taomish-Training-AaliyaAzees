import { Component, OnInit } from '@angular/core';
import { User, UserService } from '../user.service';

@Component({
  selector: 'app-form',
  standalone: false,
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.loadUsers();
  }

  loadUsers() {
    this.userService.getUsers().subscribe({
      next: (data: User[]) => {
        this.users = data;
      },
      error: (error: any) => {
        console.error('Error fetching users', error);
      }
    });
  }

  user: User = {
    id: '',
    name: '',
    email: ''
  };

  onSubmit() {
    this.userService.createUser(this.user).subscribe({
      next: (response: any) => {
        console.log('User created successfully', response);
        this.user = {
          id: '',
          name: '',
          email: ''
        };
      },
      error: (error: any) => {
        console.error('Error creating user', error);
      }
    });
  }
}
