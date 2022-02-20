package com.example.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// มัน load เฉพาะของที่ใช้ในการ test (slice testing)
// 1 test case = 1 transaction
// พอรันจบมันจะ Roll back ไปเป็นแบบเดิม
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByName_with_success() {
        // Arrange
        User user = new User();
        user.setId(1000);
        user.setName("testing");
        userRepository.save(user);
        // Act
        Optional<User> result = userRepository.findByName("testing");
        // Assert, verify
        assertTrue(result.isPresent());
    }

    @Test
    void findByName_with_failure() {
        // Act
        Optional<User> result = userRepository.findByName("testing");
        // Assert, verify
        assertFalse(result.isPresent());
    }
}