package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Нарушения пользователя на сайте
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "violations")
public class Violation {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "violation_type_id", nullable = false)
    private ViolationType violationType;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "message", nullable = false)
    @Size(max = 255, message = "Нарушение не должно содержать более 255 символов")
    private String message;
}
