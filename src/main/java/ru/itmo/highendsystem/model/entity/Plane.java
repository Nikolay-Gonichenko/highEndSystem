package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
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
    @Size(max = 255, message = "Название модели самолёта не должно содержать более 255 символов")
    private String model;

    @Column(name = "passenger_count", nullable = false)
    @Min(value = 0, message = "Количество пассажиров не может быть меньше 0")
    private Integer passengerCount;
}
