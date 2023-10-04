package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Локация, куда могут прилететь самолёты
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", nullable = false)
    @Size(max = 255, message = "Название страны не должно содержать более 255 символов")
    private String country;

    @Column(name = "city", nullable = false)
    @Size(max = 255, message = "Название города не должно содержать более 255 символов")
    private String city;

    @Column(name = "airport", nullable = false)
    @Size(max = 255, message = "Название аэропорта не должно содержать более 255 символов")
    private String airport;
}
