package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


//The class is marked as an entity
@Entity
//table with name users is created in database
@Data
@Table(name = "users")
public class User {
    //primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Autoincrement of primary key
    private Long id;
    private String name;
    private String email;
}
