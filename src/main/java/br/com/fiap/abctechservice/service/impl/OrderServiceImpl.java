package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.model.Livro;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.dto.LivroDTO;
import br.com.fiap.abctechservice.model.dto.OrderDTO;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(
            @Autowired
                    OrderRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public List<Order> getOrderList() {
        return this.repository.findAll();
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        Order order = new Order(orderDTO);
        return new OrderDTO(repository.save(order));

    }

}
