package ru.itmo.highendsystem.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * Аккаунт пользователя
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class Account implements UserDetails {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nickname", nullable = false)
    @NotBlank(message = "Имя аккаунта не должно быть пустым")
    @Size(max = 255, message = "Имя аккаунта не должно содержать более 255 символов")
    private String nickname;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "Пароль не должен быть пустым")
    @Size(max = 255, message = "Пароль не должен содержать более 255 символов")
    private String password;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "human_id", nullable = false)
    private Human human;

    @Column(name = "bonus_money", nullable = false)
    @Min(value = 0, message = "Количество бонусных миль не может быть меньше нуля")
    private Integer bonusMoney;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    @Column(name = "violation_count", nullable = false)
    @Min(value = 0, message = "Количество нарушений не может быть меньше нуля")
    @Max(value = 3, message = "Количество нарушений не может быть больше 3")
    private Integer violationCount;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public String getUsername() {
        return getNickname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
