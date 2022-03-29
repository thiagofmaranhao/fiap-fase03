package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.Assistance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssistanceDTO {

    private Long id;
    private String name;
    private String description;

    public AssistanceDTO(Assistance assistance) {
        this.id = assistance.getId();
        this.name = assistance.getName();
        this.description = assistance.getDescription();
    }

}
