package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(max = 255, message = "Фамилия не должна содержать более 255 символов")
    private String surname;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Имя не должно быть пустым")
    @Size(max = 255, message = "Имя не должно содержать более 255 символов")
    private String name;

    @Column(name = "last_name")
    @Size(max = 255, message = "Отчество не должно содержать более 255 символов")
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "document_id")
    private Document document;
}
