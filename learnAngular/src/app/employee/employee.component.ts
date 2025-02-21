import { Component } from '@angular/core';

@Component({
  selector: 'app-employee',
  standalone: false,
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent {
  employees = [
    {
      empId: 123,
      name: 'John',
      age: 34
    },
    {
      empId: 234,
      name: 'Reshma',
      age: 22
    },
    {
      empId: 345,
      name: 'Rahul',
      age: 24
    }
  ];
  minAgeEmployee: any = null;
  showMinAgeEmployee = false;
  findMinAgeEmployee() {
    const minAge = Math.min(...this.employees.map(emp => emp.age));
    this.minAgeEmployee = this.employees.filter(emp => emp.age === minAge);
    this.showMinAgeEmployee = true;
  }

  totalAge: number=0;
  showTotalAge = false
  calculateTotalAge() {
    this.totalAge = 0;
    this.employees.forEach(emp => {
      this.totalAge += emp.age;
    });
    this.showTotalAge=true;
  }

  empString: String='';
  showEmp = false;
  employeeString() {
    this.empString = '';
    this.employees.forEach(emp =>{
      this.empString += emp.name + " ";
    })
    this.showEmp=true;
  }
}
