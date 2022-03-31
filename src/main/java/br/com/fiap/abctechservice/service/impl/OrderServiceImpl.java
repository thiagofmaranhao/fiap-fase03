package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.OrderLocation;
import br.com.fiap.abctechservice.model.dto.OrderDTO;
import br.com.fiap.abctechservice.model.dto.OrderLocationDTO;
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

    @Override
    public OrderDTO endOrder(Long orderId, OrderLocationDTO orderLocationDTO) {

        Order order = repository.findById(orderId).get();

        order.setEndOrderLocation(new OrderLocation(orderLocationDTO));

        return new OrderDTO(repository.save(order));

    }

}
