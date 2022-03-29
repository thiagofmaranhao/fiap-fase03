package br.com.fiap.abctechservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUpdateLivroDTO {

    private String titulo;
    private String descricao;
    private String ISBN;
    private Date dataDePublicacao;
    private double preco;

}