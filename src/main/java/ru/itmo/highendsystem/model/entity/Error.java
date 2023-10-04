package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Ошибка, которая возникает при действиях пользователей
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "errors")
public class Error {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "error_type_id", nullable = false)
    private ErrorType errorType;
}
