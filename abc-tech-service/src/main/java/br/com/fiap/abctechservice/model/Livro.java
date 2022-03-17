package br.com.fiap.abctechservice.model;

import br.com.fiap.abctechservice.model.dto.CreateUpdateLivroDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_LIVRO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private String ISBN;

    @Column
    private Date dataDePublicacao;

    @Column
    private double preco;

    public Livro(CreateUpdateLivroDTO createUpdateLivroDTO) {
        //TODO: Implement!
    }

}
