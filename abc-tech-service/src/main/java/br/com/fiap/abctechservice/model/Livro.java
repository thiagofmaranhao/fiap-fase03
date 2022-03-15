package br.com.fiap.abctechservice.model;

import br.com.fiap.abctechservice.model.dto.CreateUpdateLivroDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String titulo;

    @Column
    @Getter
    @Setter
    private String descricao;

    @Column
    @Getter
    @Setter
    private String ISBN;

    @Column
    @Getter
    @Setter
    private Date dataDePublicacao;

    @Column
    @Getter
    @Setter
    private double preco;

    public Livro(CreateUpdateLivroDTO createUpdateLivroDTO) {
        //TODO: Implement!
    }

}
