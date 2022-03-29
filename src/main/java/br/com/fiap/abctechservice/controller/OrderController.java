package br.com.fiap.abctechservice.controller;

import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
