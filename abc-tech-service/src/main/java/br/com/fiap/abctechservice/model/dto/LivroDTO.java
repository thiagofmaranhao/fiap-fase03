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
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.descricao = livro.getDescricao();
        this.ISBN = livro.getISBN();
        //this.preco = livro.getPreco;
    }

    @Getter
    @Setter
    private long id;

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