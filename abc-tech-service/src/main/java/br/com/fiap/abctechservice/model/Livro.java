package br.com.fiap.abctechservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TB_LIVRO")
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


}
