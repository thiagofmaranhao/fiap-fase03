package br.com.fiap.abctechservice.model.dto;

import br.com.fiap.abctechservice.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * DTO para exemplo de implementação.
 *
 * @author leandrofranchi
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.descricao = livro.getDescricao();
        this.ISBN = livro.getISBN();
        //this.preco = livro.getPreco;
    }

    private long id;
    private String titulo;
    private String descricao;
    private String ISBN;
    private Date dataDePublicacao;
    private double preco;

}