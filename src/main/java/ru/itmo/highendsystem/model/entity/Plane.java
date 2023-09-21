package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Самолёт
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "planes")
public class Plane {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "passenger_count", nullable = false)
    private Integer passengerCount;
}
