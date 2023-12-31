package ru.itmo.highendsystem.secuity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.model.entity.Account;
import ru.itmo.highendsystem.repository.AccountRepository;

/**
 * Сервис для работы с пользователями в контексте безопасности.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.getAccountByNickname(username);
        if (account == null)
            throw new UsernameNotFoundException("No user with nickname = " + username);
        return account;
    }
}
