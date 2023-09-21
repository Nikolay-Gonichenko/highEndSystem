package ru.itmo.highendsystem.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тип ошибки
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "error_type")
public class ErrorType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
