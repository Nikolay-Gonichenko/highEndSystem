package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тип нарушения пользователя на сайте
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "violation_type")
public class ViolationType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 255, message = "Название типа нарушения не должно содержать более 255 символов")
    private String name;
}
