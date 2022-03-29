package br.com.fiap.abctechservice.service;

import br.com.fiap.abctechservice.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.abctechservice.model.dto.LivroDTO;
import br.com.fiap.abctechservice.model.dto.UpdatePrecoLivroDTO;

import java.util.List;

public interface LivroService {

    List<LivroDTO> buscarLivros(String titulo);

    LivroDTO buscarPorId(int id);

    LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO);

    LivroDTO atualizar(CreateUpdateLivroDTO stockCreateUpdateDTO, int id);

    LivroDTO atualizar(UpdatePrecoLivroDTO updatePrecoLivroDTO, int id);

    void delete(int id);

}
