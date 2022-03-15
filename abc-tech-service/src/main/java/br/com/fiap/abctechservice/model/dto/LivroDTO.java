package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.Livro;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DTO para exemplo de implementação.
 *
 * @author leandrofranchi
 */
public class LivroDTO {

    public LivroDTO() {

    }

    public LivroDTO(Livro livro) {

    }

    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private String titulo;

    @Getter
    @Setter
    private String descricao;

    @Getter
    @Setter
    private String ISBN;

    @Getter
    @Setter
    private Date dataDePublicacao;

    @Getter
    @Setter
    private double preco;

}