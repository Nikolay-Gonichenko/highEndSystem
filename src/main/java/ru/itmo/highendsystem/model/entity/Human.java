package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Человек
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "humans")
public class Human {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "document_id")
    private Document document;
}
