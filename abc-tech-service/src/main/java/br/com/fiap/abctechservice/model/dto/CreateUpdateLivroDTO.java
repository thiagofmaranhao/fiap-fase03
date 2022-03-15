package br.com.fiap.abctechservice.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class CreateUpdateLivroDTO {

    private String titulo;
    private String descricao;
    private String ISBN;
    private Date dataDePublicacao;
    private double preco;

}