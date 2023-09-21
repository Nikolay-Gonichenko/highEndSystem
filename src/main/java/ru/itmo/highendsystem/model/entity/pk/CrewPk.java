package ru.itmo.highendsystem.model.entity.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itmo.highendsystem.model.entity.Employee;
import ru.itmo.highendsystem.model.entity.Flight;

import java.io.Serializable;

/**
 * Составной первичный ключ для сущности "Экипаж судна"
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrewPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
}
