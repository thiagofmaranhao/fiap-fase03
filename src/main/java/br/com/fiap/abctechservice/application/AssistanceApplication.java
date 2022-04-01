package br.com.fiap.abctechservice.application;

import br.com.fiap.abctechservice.model.dto.AssistanceDTO;

import java.util.List;

public interface AssistanceApplication {

    List<AssistanceDTO> getAssistances();

}
