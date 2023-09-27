package ru.itmo.highendsystem.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itmo.highendsystem.config.CustomPostgreSQLContainer;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RoleRepositoryTest extends CustomPostgreSQLContainer {

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void findTest() {
        assertNotNull(roleRepository.findById(1L));
        assertNotNull(roleRepository.findById(2L));
        assertNotNull(roleRepository.findById(3L));
        assertNotNull(roleRepository.findById(4L));
        assertTrue(roleRepository.findById(5L).isEmpty());
    }
}
