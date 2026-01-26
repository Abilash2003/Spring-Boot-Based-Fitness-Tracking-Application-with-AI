package com.fitness.userservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String name;
    private int age;
    private double height;
    private String activities;
    private String activityLevel;
    private String goal;

    @Column(length = 500)
    private String healthNotes;
}
