package br.com.fiap.abctechservice.service;


import br.com.fiap.abctechservice.model.Order;
import br.com.fiap.abctechservice.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<Order> getOrderList();

    OrderDTO create(OrderDTO orderDTO);

}
