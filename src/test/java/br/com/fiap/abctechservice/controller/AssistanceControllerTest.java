package br.com.fiap.abctechservice.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssistanceControllerTest {

    @Autowired
    private AssistanceController assistanceController;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(assistanceController).isNotNull();
    }

    @Test
    public void test_get_assistance_not_null() {
        Assertions.assertThat(assistanceController.getAssistances()).isNotNull();
    }

}
