package br.com.fiap.abctechservice.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HealthCheckControllerTest {

    @Autowired
    private HealthCheckController healthCheckController;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(healthCheckController).isNotNull();
    }

    @Test
    public void test_status_success() {
        Assertions.assertThat(healthCheckController.status().getBody()).isEqualTo("Sucesso!");
    }

    @Test
    public void test_version() {
        Assertions.assertThat(healthCheckController.version().getBody()).isEqualTo("Sprint3 - 0.1");
    }
}
