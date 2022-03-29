package br.com.fiap.abctechservice.model;

import br.com.fiap.abctechservice.model.dto.AssistanceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "assistances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assistance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    public Assistance(AssistanceDTO assistanceDTO) {
        this.id = assistanceDTO.getId();
        this.name = assistanceDTO.getName();
        this.description = assistanceDTO.getDescription();
    }

}
