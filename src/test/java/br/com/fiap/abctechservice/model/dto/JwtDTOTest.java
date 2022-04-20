package br.com.fiap.abctechservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

@SpringBootTest
public class JwtDTOTest {

    @Test
    public void test_constructor_success() throws Exception {
        Assertions.assertNotNull(new JwtDTO());
    }

    @Test
    public void test_constructor_with_parameters_success() throws Exception {
        Assertions.assertNotNull(new JwtDTO(""));
    }

    @Test
    public void test_has_property_username() {
        JwtDTO jwtDTO = new JwtDTO("");
        jwtDTO.setToken("TKN");
        assertThat(jwtDTO, hasProperty("token", equalTo("TKN")));
    }

}
