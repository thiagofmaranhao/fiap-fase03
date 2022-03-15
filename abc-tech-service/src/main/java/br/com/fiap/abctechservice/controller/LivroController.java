package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.abctechservice.model.dto.LivroDTO;
import br.com.fiap.abctechservice.model.dto.UpdatePrecoLivroDTO;
import br.com.fiap.abctechservice.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroDTO> buscarLivros() {

        return livroService.buscarLivros("");

    }

    @GetMapping
    public List<LivroDTO> buscarLivros(@RequestParam(required = false, value = "titulo") String titulo) {

        return livroService.buscarLivros(titulo);

    }

    @GetMapping("{id}")
    public LivroDTO buscarPorId(@PathVariable int id) {

        return livroService.buscarPorId(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LivroDTO criar(@RequestBody CreateUpdateLivroDTO createUpdateLivroDTO) {

        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(3);
        livroDTO.setTitulo(createUpdateLivroDTO.getTitulo());
        livroDTO.setDescricao(createUpdateLivroDTO.getDescricao());
        livroDTO.setISBN(createUpdateLivroDTO.getISBN());
        livroDTO.setPreco(createUpdateLivroDTO.getPreco());
        livroDTO.setDataDePublicacao(createUpdateLivroDTO.getDataDePublicacao());

        return livroDTO;

    }

    @PutMapping("{id}")
    public LivroDTO atualizar(
            @PathVariable int id,
            @RequestBody CreateUpdateLivroDTO createUpdateLivroDTO
    ) {

        return livroService.atualizar(createUpdateLivroDTO, id);

    }

    @PatchMapping("{id}/preco")
    public LivroDTO atualizarPreco(
            @PathVariable int id,
            @RequestBody UpdatePrecoLivroDTO updatePrecoLivroDTO
    ) {

        return livroService.atualizar(updatePrecoLivroDTO, id);

    }

}