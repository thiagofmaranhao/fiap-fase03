package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.dto.CreateUpdateLivroDTO;
import br.com.fiap.abctechservice.model.dto.LivroDTO;
import br.com.fiap.abctechservice.model.dto.OrderDTO;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService service;

    public OrderController(
            @Autowired
                    OrderService service
    ) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Order>> getAssistanceList() {
        List<Order> list = this.service.getOrderList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO create(@RequestBody OrderDTO orderDTO) {

        return service.create(orderDTO);

    }

}
