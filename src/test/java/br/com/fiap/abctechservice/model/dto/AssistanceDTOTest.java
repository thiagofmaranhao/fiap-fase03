package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.Assistance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

@SpringBootTest
public class AssistanceDTOTest {

    @Test
    public void test_constructor_success() throws Exception {
        Assertions.assertNotNull(new AssistanceDTO());
    }

    @Test
    public void test_constructor_assistance_success() throws Exception {
        Assistance assistance = new Assistance(1L, "Assistance Name", "Assitance Description");
        Assertions.assertNotNull(new AssistanceDTO(assistance));
    }

    @Test
    public void test_has_property_id() {
        AssistanceDTO assistanceDTO = new AssistanceDTO(1L, "N", "D");
        assistanceDTO.setId(2L);
        assertThat(assistanceDTO, hasProperty("id", equalTo(2L)));
    }

    @Test
    public void test_has_property_name() {
        AssistanceDTO assistanceDTO = new AssistanceDTO(1L, "N", "D");
        assistanceDTO.setName("NAME");
        assertThat(assistanceDTO, hasProperty("name", equalTo("NAME")));
    }

    @Test
    public void test_has_property_ndescription() {
        AssistanceDTO assistanceDTO = new AssistanceDTO(1L, "N", "D");
        assistanceDTO.setDescription("DESCRIPTION");
        assertThat(assistanceDTO, hasProperty("description", equalTo("DESCRIPTION")));
    }

}
