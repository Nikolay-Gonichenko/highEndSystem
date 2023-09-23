package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Аккаунт пользователя
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "human_id", nullable = false)
    private Human human;

    @Column(name = "bonus_money", nullable = false)
    private Integer bonusMoney;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "violation_count", nullable = false)
    private Integer violationCount;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
