package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.abctechservice.model.dto.LivroDTO;
import br.com.fiap.abctechservice.model.dto.UpdatePrecoLivroDTO;
import br.com.fiap.abctechservice.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroServiceImpl implements LivroService {

    @Override
    public List<LivroDTO> buscarLivros(String titulo) {

        List<LivroDTO> livroDTOList = new ArrayList<>();
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(1);
        livroDTO.setTitulo("Aprenda Spring");
        livroDTO.setDescricao("Passo a passo com Spring Framework");
        livroDTO.setDataDePublicacao(new Date());
        livroDTO.setISBN("938472389472393482");
        livroDTOList.add(livroDTO);
        livroDTO.setPreco(15.5);
        LivroDTO livroDTO1 = new LivroDTO();
        livroDTO1.setId(2);
        livroDTO1.setTitulo("Java");
        livroDTO1.setDescricao("Tudo sobre Java");
        livroDTO1.setDataDePublicacao(new Date());
        livroDTO1.setISBN("9548675464588");
        livroDTO1.setPreco(20.4);
        livroDTOList.add(livroDTO1);

        return livroDTOList.stream()
                .filter(dto -> titulo == null || dto.getTitulo().contains(titulo))
                .collect(Collectors.toList());

    }

    @Override
    public LivroDTO buscarPorId(int id) {

        List<LivroDTO> livroDTOList = new ArrayList<>();
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(1);
        livroDTO.setTitulo("Aprenda Spring");
        livroDTO.setDescricao("Passo a passo com Spring Framework");
        livroDTO.setDataDePublicacao(new Date());
        livroDTO.setISBN("938472389472393482");
        livroDTO.setPreco(20.4);
        livroDTOList.add(livroDTO);
        LivroDTO livroDTO1 = new LivroDTO();
        livroDTO1.setId(2);
        livroDTO1.setTitulo("Java");
        livroDTO1.setDescricao("Tudo sobre Java");
        livroDTO1.setDataDePublicacao(new Date());
        livroDTO1.setISBN("9548675464588");
        livroDTO1.setPreco(15.3);
        livroDTOList.add(livroDTO1);

        switch (id) {
            case 1:
                return livroDTO;
            case 2:
                return livroDTO1;
            default:
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Livro não encontrado");
        }

    }

    @Override
    public LivroDTO criar(CreateUpdateLivroDTO createUpdateLivroDTO) {

        return null;

    }

    @Override
    public LivroDTO atualizar(CreateUpdateLivroDTO createUpdateLivroDTO, int id) {

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(id);
        livroDTO.setTitulo(createUpdateLivroDTO.getTitulo());
        livroDTO.setDescricao(createUpdateLivroDTO.getDescricao());
        livroDTO.setISBN(createUpdateLivroDTO.getISBN());
        livroDTO.setPreco(createUpdateLivroDTO.getPreco());
        livroDTO.setDataDePublicacao(createUpdateLivroDTO.getDataDePublicacao());

        return livroDTO;

    }

    @Override
    public LivroDTO atualizar(UpdatePrecoLivroDTO updatePrecoLivroDTO, int id) {

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(id);
        livroDTO.setPreco(updatePrecoLivroDTO.getPreco());

        return livroDTO;

    }

    @Override
    public void delete(int id) {

    }
}