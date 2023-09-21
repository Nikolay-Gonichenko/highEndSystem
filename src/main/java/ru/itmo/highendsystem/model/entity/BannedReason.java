package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Причина блокировки человека на сайте авиакомпании
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "banned_reasons")
public class BannedReason {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
}
