package com.example.hello.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// Integration test (for test connection)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserGatewayIntegrationTest {

    @Autowired
    private UserGateway userGateway;

    // เนื่องจาก integration test เป็นการ run จริง เราจึงควรตั้ง schedule เพื่อไม่ให้กระทบส่วนอื่น
    // ผลกระทบเกิดจากปลายทางสามารถเปลี่ยน result หรือปัญหาด้าน network -> generate fake server (
    @Test
    void getUserById() {
        // Act
        UserResponse result = userGateway.getUserById(1);
        // Assert
        // assertEquals(1, result.getId());
        // assertEquals("Leanne Graham", result.getName());
    }
}