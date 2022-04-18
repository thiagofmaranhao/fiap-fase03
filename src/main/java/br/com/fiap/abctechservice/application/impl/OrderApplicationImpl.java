package br.com.fiap.abctechservice.application.impl;

import br.com.fiap.abctechservice.application.OrderApplication;
import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.OrderLocation;
import br.com.fiap.abctechservice.model.dto.OrderDTO;
import br.com.fiap.abctechservice.model.dto.OrderLocationDTO;
import br.com.fiap.abctechservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderApplicationImpl implements OrderApplication {

    private final OrderService orderService;

    public OrderApplicationImpl(@Autowired OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order createOrder(OrderDTO orderDto) {
        Order order = new Order();
        order.setOperatorId(orderDto.getOperatorId());
        order.setStartOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getStartOrderLocation()));
        order.setEndOrderLocation(getOrderLocationFromOrderLocationDto(orderDto.getEndOrderLocation()));

        return this.orderService.saveOrder(order, orderDto.getAssistances());
    }

    private OrderLocation getOrderLocationFromOrderLocationDto(OrderLocationDTO orderLocationDto) {
        OrderLocation location = new OrderLocation();
        location.setLatitude(orderLocationDto.getLatitude());
        location.setLongitude(orderLocationDto.getLatitude());
        location.setDate(orderLocationDto.getDate());
        return location;
    }

}
