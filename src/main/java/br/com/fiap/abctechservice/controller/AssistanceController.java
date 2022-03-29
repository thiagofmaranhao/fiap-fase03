package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.service.AssistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assistance")
public class AssistanceController {

    private final AssistanceService service;

    public AssistanceController(
            @Autowired
                    AssistanceService service
    ) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Assistance>> getAssistanceList() {
        List<Assistance> list = this.service.getAssistanceList();
        return ResponseEntity.ok(list);
    }
}
