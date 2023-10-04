package ru.itmo.highendsystem.model.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
    @Size(max = 255, message = "Тип ошибки не должен содержать более 255 символов")
    private String name;
}
