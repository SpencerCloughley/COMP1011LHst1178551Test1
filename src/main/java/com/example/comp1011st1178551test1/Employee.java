package com.example.comp1011st1178551test1;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String department;
    private String email;
    private double salary;

    public Employee(int id, String firstName, String lastName, LocalDate birthday, String department, String email, double salary) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthday(birthday);
        setDepartment(department);
        setEmail(email);
        setSalary(salary);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>0)
            this.id = id;
        else
            throw new IllegalArgumentException("Id must be larger than 0");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        firstName = firstName.replace(" ","");
        if(firstName.length()>1) {
            firstName = formatName(firstName);
            this.firstName = firstName;
        }
        else
            throw new IllegalArgumentException(firstName + " invalid, must be longer than 1 characters");

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        lastName = lastName.replace(" ","");
        if(lastName.length()>1) {
            lastName = formatName(lastName);
            this.lastName = lastName;
        }
        else
            throw new IllegalArgumentException(lastName + " invalid, must be longer than 1 characters");

    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        if(birthday.isBefore(LocalDate.now()))
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("Birthday must not be in the future");
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        department=department.substring(0,1).toUpperCase() + department.substring(1).toLowerCase();
        if(department.equals("Sales") || department.equals("Marketing") || department.equals("Finance") || department.equals("Research")){
            this.department = department;
        }
        else{
            department=department.toUpperCase();
            if(department.equals("IT") || department.equals("HR"))
                this.department = department;
            else
                throw new IllegalArgumentException("Incorrect department entered, must be one of: Sales, Marketing, Finance, HR, IT, or Research");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email=email.replace(" ","");
        if(email.length()>4 && email.contains("@") && email.contains("."))
            this.email = email;
        else
            throw new IllegalArgumentException("Email not valid, must be at least 5 characters long and contain an '@' and a '.'");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary>50000)
            this.salary = salary;
        else
            throw new IllegalArgumentException("Salary not valid, must be greater than 50,000");
    }

    private String formatName(String name){
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        name = name.trim();
        return name;
    }
    
    public String getFullName(){
        return firstName + " " + lastName;
    }
}
