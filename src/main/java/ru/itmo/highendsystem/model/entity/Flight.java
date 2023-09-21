package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Полёт
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "flights")
public class Flight {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Column(name = "date_finish", nullable = false)
    private Date dateFinish;

    @ManyToOne
    @JoinColumn(name = "flight_status_id", nullable = false)
    private FlightStatus flightStatus;

    @ManyToOne
    @JoinColumn(name = "plane_id", nullable = false)
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;
}
