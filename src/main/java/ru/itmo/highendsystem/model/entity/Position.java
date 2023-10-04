package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Должность сотрудника авиакомпании
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "positions")
public class Position {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 255, message = "Название должности не должно содержать более 255 символов")
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
