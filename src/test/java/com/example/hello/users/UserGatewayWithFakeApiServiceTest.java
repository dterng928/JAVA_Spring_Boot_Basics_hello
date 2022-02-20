package com.example.hello.users;

import com.example.hello.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 9999)
class UserGatewayWithFakeApiServiceTest {

    @Autowired
    private UserGateway userGateway;

    @Test
    void getPostById() throws IOException {
        // Arrange : create Fake data for external APIs
        stubFor(get(urlPathEqualTo("/users/1"))
                .willReturn(aResponse()
                        .withBody(read("classpath:userApiResponse.json"))
                        .withHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(200)));

        // Act
        UserResponse userResponse = userGateway.getUserById(1);
        //Assert, verify
        assertEquals(1, userResponse.getId());
        assertEquals("Test Name", userResponse.getName());
        assertEquals("Test Username", userResponse.getUsername());
    }

    public static String read(String filePath) throws IOException {
        File file = ResourceUtils.getFile(filePath);
        return new String(Files.readAllBytes(file.toPath()));
    }
}