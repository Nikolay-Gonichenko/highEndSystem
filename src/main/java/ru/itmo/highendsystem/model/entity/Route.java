package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Маршрут, по которому перемещаются самолёты
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "routes")
public class Route {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_from_id", nullable = false)
    private Location fromLocation;

    @ManyToOne
    @JoinColumn(name = "location_to_id", nullable = false)
    private Location toLocation;
}
