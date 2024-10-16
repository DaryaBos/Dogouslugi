package ru.practice.dogouslugi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@Table(name = "dog")
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String age;
    private String sex;
    private String breed;
}
