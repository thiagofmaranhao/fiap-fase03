package br.com.fiap.abctechservice.service.impl;

import br.com.fiap.abctechservice.handler.exception.MaximumAssistancesException;
import br.com.fiap.abctechservice.handler.exception.MinimumAssistancesRequiredException;
import br.com.fiap.abctechservice.model.Assistance;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.repository.AssistanceRepository;
import br.com.fiap.abctechservice.repository.OrderRepository;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final AssistanceRepository assistanceRepository;

    public OrderServiceImpl(@Autowired OrderRepository orderRepository,
                            @Autowired AssistanceRepository assistanceRepository) {
        this.orderRepository = orderRepository;
        this.assistanceRepository = assistanceRepository;
    }

    @Override
    public void saveOrder(Order order, List<Long> arrayAssists) {
        ArrayList<Assistance> assistances = new ArrayList<>();

        arrayAssists.forEach(i -> {
            Assistance assistance = this.assistanceRepository.findById(i).orElseThrow();
            assistances.add(assistance);
        });

        order.setAssistances(assistances);

        if (!order.hasMinAssists()) {
            throw new MinimumAssistancesRequiredException("Ordem deve ter no minimo um assistence.", "");
        } else if (order.exceedsMaxAssists()) {
            throw new MaximumAssistancesException("Ordem deve ter no máximo 5 assistences.", "");
        }

        orderRepository.save(order);
    }

    /*
    @Override
    public List<Order> listOrdersByOperator(Long operatorId) {
        return null;
    }

     */

    /*
    @Override
    public List<Order> getOrderList() {
        return this.repository.findAll();
    }

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        Order order = new Order(orderDTO);
        return new OrderDTO(repository.save(order));

    }
    */
}
