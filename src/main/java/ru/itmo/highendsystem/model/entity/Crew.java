package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.highendsystem.model.entity.pk.CrewPk;

/**
 * Экипаж судна
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crew")
public class Crew {

    @EmbeddedId
    private CrewPk crewPk;

    @Column(name = "role", nullable = false)
    private String role;
}
