package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Заблокированные люди
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "banned_list")
public class BannedList {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "human_id", nullable = false)
    private Human human;

    @ManyToOne
    @JoinColumn(name = "reason_id", nullable = false)
    private BannedReason bannedReason;
}
