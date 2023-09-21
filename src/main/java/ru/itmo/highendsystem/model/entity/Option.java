package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Дополнительная услуга
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "options")
public class Option {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_type_id", nullable = false)
    private OptionType optionType;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;
}
