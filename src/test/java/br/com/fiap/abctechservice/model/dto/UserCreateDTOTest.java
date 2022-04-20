package br.com.fiap.abctechservice.model.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

@SpringBootTest
public class UserCreateDTOTest {
    private String username;
    private String password;

    @Test
    public void test_constructor_success() throws Exception {
        Assertions.assertNotNull(new UserCreateDTO());
    }

    @Test
    public void test_constructor_with_parameters_success() throws Exception {
        Assertions.assertNotNull(new UserCreateDTO("", ""));
    }

    @Test
    public void test_has_property_username() {
        UserCreateDTO userCreateDTO = new UserCreateDTO("", "");
        userCreateDTO.setUsername("USERNAME");
        assertThat(userCreateDTO, hasProperty("username", equalTo("USERNAME")));
    }

    @Test
    public void test_has_property_password() {
        UserCreateDTO userCreateDTO = new UserCreateDTO("", "");
        userCreateDTO.setPassword("PWD");
        assertThat(userCreateDTO, hasProperty("password", equalTo("PWD")));
    }

}